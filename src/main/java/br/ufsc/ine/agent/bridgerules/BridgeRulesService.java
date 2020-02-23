package br.ufsc.ine.agent.bridgerules;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import agent.AgentParser.BridgeRuleContext;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.custom.CustomContext;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.context.bayesian.BayesianContextService;

public class BridgeRulesService {

    private static final String VARIABLE = "X";
    private static BridgeRulesService ourInstance = new BridgeRulesService();

    BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
    DesiresContextService desiresContext = DesiresContextService.getInstance();
    CommunicationContextService communicationContext = CommunicationContextService.getInstance();
    IntentionsContextService intentionsContext = IntentionsContextService.getInstance();
    PlansContextService plansContext = PlansContextService.getInstance();
    
    HashMap<String, CustomContext> customContexts = new HashMap<>();
    ArrayList<BridgeRule> bridgeRules = new ArrayList<>(); 

    private BridgeRulesService() {

    }


    
    public static BridgeRulesService getInstance() {
        return ourInstance;
    }

    public List<BridgeRule> bridgeRules(){


        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();
        body.setAnd(planMember);
        plan.setAnd(planMember);
        planMember.setAnd(desires);
        BridgeRule r1 = BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build();

        //com problema
        BridgeRule r2 =  BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause("X").build())
                .body(Body.builder().context(desiresContext).clause("X")
                        .and(Body.builder().context(beliefsContext)
                                .notClause("X").build()).build())
                .build();

        List<BridgeRule> rules = new ArrayList<BridgeRule>( );
        rules.add(r1);        
        
        //rules.add(r2);
        return rules;
    }

    public void executeRules() {
    	for(BridgeRule rule: getInstance().bridgeRules)
    		rule.execute();
    }
    
    public void addBrigeRule(String rule) {
    	String headRule = rule.split(":-")[0].trim();
    	String bodyRule = rule.split(":-")[1].trim();
    	
    	Head head = parseHead(headRule);
    	Body body = parseBody(bodyRule);
    	
    	BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
    			
    	getInstance().bridgeRules.add(bridgeRule);
    }
    
    protected Head parseHead(String headRule) {
    	Pattern pattern = Pattern.compile("[|&]*[\\sa-zA-Z_()0-9]+");
    	Matcher matcher = pattern.matcher(headRule);
    	
    	String context = matcher.group();
    	String clause = matcher.group();
    	
    	boolean isNegated = context.startsWith("not ");
    	if(!isNegated) isNegated = context.startsWith("~");
    	
    	if(isNegated)
    		context = context.replaceFirst("^(not)*~*", "");
    	
    	return Head.builder().context(getInstance().customContexts.get(context)).not(isNegated).clause(clause).build();
    }
    	
    protected Body parseBody(String bodyRule) {
    	ArrayList<String> rules = new ArrayList<>();
    	
    	Pattern pattern = Pattern.compile("[|&]*[\\sa-zA-Z_()0-9]+");
    	Matcher matcher = pattern.matcher(bodyRule);
    	
    	while(matcher.find())
            rules.add(matcher.group());
        
    	Body body = parseTerm(rules.remove(0));
    	
    	ArrayList<String> andTerms = new ArrayList<>();
    	ArrayList<String> orTerms = new ArrayList<>();
    	
    	for(String term: rules)
    		if(term.startsWith("|"))
    			orTerms.add(term.substring(1).trim());
    		else if(term.startsWith("&"))
    			andTerms.add(term.substring(1).trim());
    	
    	for(String term: andTerms)
    		body.setAnd(parseTerm(term.trim()));
    	
    	for(String term: orTerms)
    		body.setOr(parseTerm(term.trim()));	
    	
    	return body;
    }
    
    protected Body parseTerm(String term) {
    	Pattern pattern = Pattern.compile("[|&]*[\\sa-zA-Z_()0-9]+");
    	Matcher matcher = pattern.matcher(term);
    	
    	String context = matcher.group();
    	String clause = matcher.group();
    	
    	boolean isNegated = context.startsWith("not ");
    	boolean isClauseNegated = clause.startsWith("not ");
	
    	if(!isNegated) isNegated = context.startsWith("~");
    	if(!isClauseNegated) isClauseNegated = clause.startsWith("~");
    	
    	if(isNegated)
    		context = context.replaceFirst("^(not)*~*", "");
    	if(isClauseNegated)
    		clause = clause.replaceFirst("^(not)*~*", "");
    	
    	//TODO: Qual metodo para indicar quando o termo em si e negado?
    	boolean isNegatedSum = (!isNegated || !isClauseNegated) && (isNegated || isClauseNegated);
    	
    	if(isNegatedSum)
    		return Body.builder().context(getInstance().customContexts.get(context)).notClause(clause).build();
    	return Body.builder().context(getInstance().customContexts.get(context)).clause(clause).build();
    }
    
    public void addCustomContext(CustomContext context) {
    	getInstance().customContexts.put(context.getName(), context);
    }
    
    public void rules(List<BridgeRuleContext> rules) {
    	
    	// list.stream().map(c -> c.getClauses()).flatMap(l -> l.stream());
    	// List<String> stringRules = rules.stream().map(c -> c.getClauses()).flatMap(l -> l.stream()).collect(Collectors.toList());
    	
    	
    	
    	List<String> stringRules = rules.stream().map(c -> (c.head().getText() + " :- " + c.body().getText())).collect(Collectors.toList());
    	
    	stringRules.forEach(System.out::println);
    	
    	
    	
    	
    }
    
    
    
    
    public void executeBdiRules() {
        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();
        body.setAnd(desires);
        desires.setAnd(plan);
        plan.setAnd(planMember);        
         BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build().execute();
         
        Body bodyT = Body.builder().context(beliefsContext).clause("car(X,yes)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("vehicle").build())
                 .body(bodyT)
                 .build().execute();

         Body bodyR = Body.builder().context(beliefsContext).clause("car(X,no)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("-vehicle").build())
                 .body(bodyR)
                 .build().execute();
         
         Body bodyScreen = Body.builder().context(beliefsContext).clause("smartphone(screen, on)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("screenDistraction").build())
                 .body(bodyScreen)
                 .build().execute();
         
         Body bodyScreenNeg = Body.builder().context(beliefsContext).clause("smartphone(screen, off)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("-screenDistraction").build())
                 .body(bodyScreenNeg)
                 .build().execute();
         
         Body bodySound = Body.builder().context(beliefsContext).clause("smartphone(headphone, on)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("soundDistraction").build())
                 .body(bodySound)
                 .build().execute();
         
         Body bodySoundNeg = Body.builder().context(beliefsContext).clause("smartphone(headphone, off)").build();
         BridgeRule.builder()
                 .head(Head.builder().context(BayesianContextService.getInstance()).clause("-soundDistraction").build())
                 .body(bodySoundNeg)
                 .build().execute();


    }
}
