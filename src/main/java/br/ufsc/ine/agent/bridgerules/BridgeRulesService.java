package br.ufsc.ine.agent.bridgerules;


import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;


import java.util.ArrayList;
import java.util.List;

public class BridgeRulesService {

    private static final String VARIABLE = "X";
    private static BridgeRulesService ourInstance = new BridgeRulesService();

    BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
    DesiresContextService desiresContext = DesiresContextService.getInstance();
    CommunicationContextService communicationContext = CommunicationContextService.getInstance();
    IntentionsContextService intentionsContext = IntentionsContextService.getInstance();

    private BridgeRulesService() {

    }

    public static BridgeRulesService getInstance() {
        return ourInstance;
    }

    public List<BridgeRule> bridgeRules(){

        // 1
        BridgeRule r1 =  BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause(VARIABLE).build())
                .body(Body.builder().context(communicationContext).clause("sense("+VARIABLE+")").build())
                .build();


        // 3
        BridgeRule r3 =  BridgeRule.builder()
                .head(Head.builder().not(true).context(desiresContext).clause(VARIABLE).build())
                .body(Body.builder().context(beliefsContext).notClause(VARIABLE).build())
                .build();


        // 4 - NAO USAR
        BridgeRule r4 =  BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause(VARIABLE).build())
                .body(Body.builder().context(desiresContext).clause(VARIABLE).build())
                .build();

        // 5
        BridgeRule r5 =  BridgeRule.builder()
                .head(Head.builder().not(true).context(intentionsContext).clause(VARIABLE).build())
                .body(Body.builder().context(desiresContext).notClause(VARIABLE).build())
                .build();

        // 6
        BridgeRule r6 =  BridgeRule.builder()
                .head(Head.builder().context(desiresContext).clause(VARIABLE).build())
                .body(Body.builder().context(intentionsContext).clause(VARIABLE).build())
                .build();

        List<BridgeRule> rules = new ArrayList<BridgeRule>( );
        rules.add(r1);
        rules.add(r3);
        //rules.add(r4);
        rules.add(r5);
        rules.add(r6);
        return rules;
    }

    private List<BridgeRule> strongRealism(){
        // 1
        BridgeRule r1 =  BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause(VARIABLE).build())
                .body(Body.builder().context(communicationContext).clause("sense("+VARIABLE+")").build())
                .build();


        // 3
        BridgeRule r3 =  BridgeRule.builder()
                .head(Head.builder().not(true).context(desiresContext).clause(VARIABLE).build())
                .body(Body.builder().context(beliefsContext).notClause(VARIABLE).build())
                .build();


        // 4
        BridgeRule r4 =  BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause(VARIABLE).build())
                .body(Body.builder().context(desiresContext).clause(VARIABLE).build())
                .build();

        // 5
        BridgeRule r5 =  BridgeRule.builder()
                .head(Head.builder().not(true).context(intentionsContext).clause(VARIABLE).build())
                .body(Body.builder().context(desiresContext).notClause(VARIABLE).build())
                .build();

        // 6
        BridgeRule r6 =  BridgeRule.builder()
                .head(Head.builder().context(desiresContext).clause(VARIABLE).build())
                .body(Body.builder().context(intentionsContext).clause(VARIABLE).build())
                .build();

        List<BridgeRule> rules = new ArrayList<BridgeRule>( );
        rules.add(r1);
        rules.add(r3);
        rules.add(r4);
        rules.add(r5);
        rules.add(r6);
        return rules;
    }

    public void executeBdiRules() {

        this.bridgeRules().stream().filter(r->!r.getHead().isNot()).forEach(r->{  r.execute();});

        /*BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
        CommunicationContextService communicationContext = CommunicationContextService.getInstance();
        IntentionsContextService  intentionsContext = IntentionsContextService.getInstance();
        DesiresContextService desiresContext = DesiresContextService.getInstance();

        // Regra: BC(X) :- CC(X).
        BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause(VARIABLE).build())
                .body(Body.builder().context(communicationContext).clause("sense("+VARIABLE+")").build())
                .build().execute();


        // Regra: IC(X) :- DC(X) and not BC(X).
        BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(Body.builder().context(desiresContext).clause(VARIABLE)
                        .and(Body.builder().context(beliefsContext).notClause(VARIABLE).build())
                        .build())
                .build().execute();

        // Regra: DC(X) :- IC(X) and BC(X).
       /* BridgeRule.builder()
                .head(Head.builder().context(desiresContextService).clause(VARIABLE).build())
                .body(Body.builder().context(intentionsContext).clause(VARIABLE)
                        .and(Body.builder().context(beliefsContext).clause(VARIABLE).build()).build())
                .build().execute();




        System.out.println("crenças: " + beliefsContext.getTheory().toString());
        System.out.println("desejos: " + desiresContext.getTheory().toString());
        System.out.println("intenções: " + intentionsContext.getTheory().toString());
*/


    }
}
