package br.ufsc.ine.agent.bridgerules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.swing.plaf.BorderUIResource;

import org.antlr.v4.runtime.tree.ParseTree;

import com.github.davidmoten.rx.Strings;

import agent.AgentParser.BodyContext;
import agent.AgentParser.BridgeRuleContext;
import agent.AgentParser.ContextNameContext;
import agent.AgentParser.HeadContext;
import agent.AgentParser.LogicalContextContext;
import agent.AgentParser.LogicalOperatorContext;
import agent.AgentParser.PlannerContextContext;
import agent.AgentParser.TermContext;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.custom.CustomContext;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;

public class BridgeRulesService {

	private static final String VARIABLE = "X";
	private static BridgeRulesService ourInstance = new BridgeRulesService();

	BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
	DesiresContextService desiresContext = DesiresContextService.getInstance();
	CommunicationContextService communicationContext = CommunicationContextService.getInstance();
	IntentionsContextService intentionsContext = IntentionsContextService.getInstance();
	PlansContextService plansContext = PlansContextService.getInstance();

	HashMap<String, CustomContext> customContexts = new HashMap<>();
	HashMap<String, ContextService> cContexts = new HashMap<>();

	ArrayList<BridgeRule> bridgeRules = new ArrayList<>();

	private BridgeRulesService() {
		cContexts.put("beliefs", beliefsContext);
		cContexts.put("desires", desiresContext);
		cContexts.put("communication", communicationContext);
		cContexts.put("intentions", intentionsContext);
		cContexts.put("planner", plansContext);

	}

	public static BridgeRulesService getInstance() {
		return ourInstance;
	}

	public List<BridgeRule> bridgeRules() {

		Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
		Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
		Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
		Body desires = Body.builder().context(desiresContext).clause("Y").build();
		body.setAnd(planMember);
		plan.setAnd(planMember);
		planMember.setAnd(desires);
		BridgeRule r1 = BridgeRule.builder().head(Head.builder().context(beliefsContext).clause("X").build()).body(body)
				.build();

		// com problema
		BridgeRule r2 = BridgeRule.builder().head(Head.builder().context(intentionsContext).clause("X").build())
				.body(Body.builder().context(desiresContext).clause("X")
						.and(Body.builder().context(beliefsContext).notClause("X").build()).build())
				.build();

		List<BridgeRule> rules = new ArrayList<BridgeRule>();
		rules.add(r1);
		// rules.add(r2);
		return rules;
	}

	public void executeRules() {
		for (BridgeRule rule : getInstance().bridgeRules)
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
		if (!isNegated)
			isNegated = context.startsWith("~");

		if (isNegated)
			context = context.replaceFirst("^(not)*~*", "");

		return Head.builder().context(getInstance().customContexts.get(context)).not(isNegated).clause(clause).build();
	}

	protected Body parseBody(String bodyRule) {
		ArrayList<String> rules = new ArrayList<>();

		Pattern pattern = Pattern.compile("[|&]*[\\sa-zA-Z_()0-9]+");
		Matcher matcher = pattern.matcher(bodyRule);

		while (matcher.find())
			rules.add(matcher.group());

		Body body = parseTerm(rules.remove(0));

		ArrayList<String> andTerms = new ArrayList<>();
		ArrayList<String> orTerms = new ArrayList<>();

		for (String term : rules)
			if (term.startsWith("|"))
				orTerms.add(term.substring(1).trim());
			else if (term.startsWith("&"))
				andTerms.add(term.substring(1).trim());

		for (String term : andTerms)
			body.setAnd(parseTerm(term.trim()));

		for (String term : orTerms)
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

		if (!isNegated)
			isNegated = context.startsWith("~");
		if (!isClauseNegated)
			isClauseNegated = clause.startsWith("~");

		if (isNegated)
			context = context.replaceFirst("^(not)*~*", "");
		if (isClauseNegated)
			clause = clause.replaceFirst("^(not)*~*", "");

		// TODO: Qual metodo para indicar quando o termo em si e negado?
		boolean isNegatedSum = (!isNegated || !isClauseNegated) && (isNegated || isClauseNegated);

		if (isNegatedSum)
			return Body.builder().context(getInstance().customContexts.get(context)).notClause(clause).build();
		return Body.builder().context(getInstance().customContexts.get(context)).clause(clause).build();
	}

	public void addCustomContext(CustomContext context) {
		getInstance().customContexts.put(context.getName(), context);
	}

	public void addCustomContext(LangContext context) {
		CustomContext cc = new CustomContext(context.getName());
		for (String fact : context.getClauses()) {
			cc.appendFact(fact);
		}

		getInstance().customContexts.put(cc.getName(), cc);
	}

	public void addCustomContext(ContextService contextService) {
		getInstance().cContexts.put(contextService.getName(), contextService);

	}

	public void rules(List<BridgeRuleContext> rules) {

		// list.stream().map(c -> c.getClauses()).flatMap(l -> l.stream());
		// List<String> stringRules = rules.stream().map(c -> c.getClauses()).flatMap(l
		// -> l.stream()).collect(Collectors.toList());

		List<String> stringRules = rules.stream().map(c -> (c.head().getText() + " :- " + c.body().getText()))
				.collect(Collectors.toList());

		stringRules.forEach(System.out::println);

	}
	
	

	public void createBridgeRule(HeadContext headContext, BodyContext bodyContext) {
		
		ContextService cc = cContexts.get(headContext.contextName().getText());
		String head_term = headContext.term().getText();
		
		if(headContext.contextName().getText().equalsIgnoreCase("planner")) {
			head_term = plannerBridgeRule(headContext);
		}
		//se for plan dá de adicionar a ação
		ContextService cBody = cContexts.get(bodyContext.contextName(0).getText().replaceAll("_", "")); //obtem contexto do body
		
		Body previous = Body.builder().context(cBody).clause(bodyContext.term(0).getText()).build(); // cria o body
		ContextService cBodyI;
		Body current;
		int i = 1;	
		List<Body> bodies = new ArrayList<>();
		bodies.add(previous);
		
		
		for (LogicalOperatorContext op : bodyContext.logicalOperator()) {
			
			cBodyI = cContexts.get(bodyContext.contextName(i).getText());
			current = Body.builder().context(cBodyI).clause(bodyContext.term(i).getText()).build(); 
			
			if(op.getText().equalsIgnoreCase("&")) {
				bodies.get(i-1).setAnd(current); 
			}else {
				bodies.get(i-1).setOr(current); //TODO quando existir mais de um termo da forma: contexto term term term... não funciona
			}
			bodies.add(i, current);

			i++;

		}
		
		Head head = Head.builder().context(cc).clause(head_term).build();
		BridgeRule.builder().head(head).body(bodies.get(0)).build().execute();
		
		

	}
	
	 /*
	
	public void createBridgeRuleRecursive(HeadContext headContext, BodyContext bodyContext) {
		ContextService cc = cContexts.get(headContext.contextName().getText());
		String head_term = headContext.term().getText();
		
		if(headContext.contextName().getText().equalsIgnoreCase("planner")) {
			head_term = plannerBridgeRule(headContext);
		}
		//se for plan dá de adicionar a ação
		ContextService cBody = cContexts.get(bodyContext.contextName(0).getText()); //obtem contexto do body
		
		Body previous = Body.builder().context(cBody).clause(bodyContext.term(0).getText()).build(); // cria o body
		ContextService cBodyI;
		this.contexts =  bodyContext.term();
		Body current;
		int i = 0;		
		List<LogicalOperatorContext> operators = bodyContext.logicalOperator();
		
		if(!operators.isEmpty()) {
			
			i++;
			createBody(i, operators.get(i), contexts.get(i), previous);

		}else {
			// nao tem previous dai
		}
		
		
		for (LogicalOperatorContext op : bodyContext.logicalOperator()) {
			
			cBodyI = cContexts.get(bodyContext.contextName(i).getText()); //pega o contexto apos o operador
			current = Body.builder().context(cBodyI).clause(bodyContext.term(i).getText()).build(); //cria o body do contexto apos o operador
			
			if(op.getText().equalsIgnoreCase("&")) {
				previous.setAnd(current); //seta o contexto apos o operador
			}else {
				previous.setOr(current); //TODO quando existir mais de um termo da forma: contexto term term term... não funciona
			}
			previous = current; //troca de contextos para setar and do proximo
			i++;
			
		}
		
		Body cbody = Body.builder().context(cBody).clause(bodyContext.term(0).getText()).build();// iterar sobre o conjunto ? NAO SEI SE PRECISA MAIS
		
		
		Head head = Head.builder().context(cc).clause(head_term).build();
		BridgeRule.builder().head(head).body(cbody).build().execute();
	}
	
	public void createBody(int index, int indexOperator,List<LogicalOperatorContext> logicalOperatorContext, Body current, Body previous) {
		
		
		if(index < contexts.size()) {
			if(logicalOperatorContext.get(indexOperator).getText().equalsIgnoreCase("&")) {
				previous.setAnd(current); //seta o contexto apos o operador
			}else {
				previous.setOr(current); //TODO quando existir mais de um termo da forma: contexto term term term... não funciona
			}
			indexOperator++;
			
			index++;		
			createBody(index, logicalOperatorContext, termContext, previous);
		}
		

		
		
		
	}*/
	
	public String plannerBridgeRule(HeadContext headContext) {

		String actionAsPredicate = headContext.term().getText().replaceAll("\\[|\\]", "");		
		actionAsPredicate = "act("+actionAsPredicate+")";	
		
		return actionAsPredicate;

	}

	public void executeBdiRules() {
		Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
		Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
		Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
		Body desires = Body.builder().context(desiresContext).clause("Y").build();

		body.setAnd(plan);
		plan.setAnd(planMember);
		planMember.setAnd(desires);
		BridgeRule.builder().head(Head.builder().context(beliefsContext).clause("X").build()).body(body).build()
				.execute();

		/* bridge rule to add intentions based on plans, desires, and beliefs */

		Body desireIntention = Body.builder().context(desiresContext).clause("X").build();
		Body notBelief = Body.builder().context(beliefsContext).notClause("X").build();
		Body planMemberIntention = Body.builder().context(plansContext).clause("member(X,Z)").build();
		Body notIntention = Body.builder().context(intentionsContext).notClause("X").build();

		desireIntention.setAnd(notBelief);
		notBelief.setAnd(planMemberIntention);
		planMemberIntention.setAnd(notIntention);
		BridgeRule.builder().head(Head.builder().context(intentionsContext).clause("X").build()).body(desireIntention)
				.build().execute();

	}

}
