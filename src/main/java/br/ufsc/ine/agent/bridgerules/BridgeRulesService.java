package br.ufsc.ine.agent.bridgerules;


import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;

public class BridgeRulesService {

    private static final String VARIABLE = "X";
    private static BridgeRulesService ourInstance = new BridgeRulesService();

    private BridgeRulesService() {

    }

    public static BridgeRulesService getInstance() {
        return ourInstance;
    }

    public void executeBdiRules() {

        BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
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
