package br.ufsc.ine.agent.bridgerules;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Ignore
public class StrongRealismTest {

    public static final PlansContextService PLANS_CONTEXT_SERVICE = PlansContextService.getInstance();
    BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
    DesiresContextService desiresContext = DesiresContextService.getInstance();
    CommunicationContextService communicationContext = CommunicationContextService.getInstance();
    IntentionsContextService intentionsContext = IntentionsContextService.getInstance();
    PlansContextService plansContext = PlansContextService.getInstance();


    @Test
    public void testaRegraParaStrongRealism(){
       /* BridgeRulesService.getInstance();
        CommunicationContextService.getInstance().appendFact("sense(s(2)).");
        PlansContextService.getInstance().appendFact("preconditions_related(s(_)).");

        BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(Body.builder().context(plansContext).clause("preconditions_related(X)")
                        .and(Body.builder().context(communicationContext).clause("sense(X)").build())
                        .build())
                .build().execute();

        // add s(2). pois esta relacionado a uma pré condicao de um plano
        System.out.println(" Contexto de crenças: "+ BeliefsContextService.getInstance().getTheory().toString());

        */




        PlansContextService.getInstance().appendFact("plans(i(a),_,p(_),_).");
        CommunicationContextService.getInstance().appendFact("sense(p(1)).");
        desiresContext.appendFact("x(a).");

        Body and  =  Body.builder()
                .context(desiresContext).clause("Y")
                .and(Body.builder().context(communicationContext).clause("sense(X)").build()).build();

        BridgeRule r2 = BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(Body.builder().context(plansContext).clause("plans(Y,_,X,_)")
                        .and(and)
                        .build())
                .build();

        r2.execute();
        System.out.println(BeliefsContextService.getInstance().getTheory().toString());

    }








    //TODO: add busca em lista ou verificar pelo 'somethingToBeTrue'
    @Test
    public void testStrongRealism(){



        BridgeRulesService.getInstance();
        CommunicationContextService.getInstance().appendFact("sense(p(2)).");
        PlansContextService.getInstance().appendFact("preconditions_related(s(_)).");

        BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(Body.builder().context(plansContext).clause("preconditions_related(X)")
                        .and(Body.builder().context(communicationContext).clause("sense(X)").build())
                        .build())
                .build().execute();

        System.out.println(" Contexto de crenças"+ BeliefsContextService.getInstance().getTheory().toString());

        /*String plan = "plan(position(10,10), " +
                "[action(moveFront(_), \\+ position(10,_), " +
                "position(_,_))], position(_,_), position(_,_)).";
        plansContext.appendFact(plan);

        System.out.println(plansContext.getTheory().toString());

        boolean verify = BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("position(10, 10)").build())
                .body(Body.builder().clause("plan(position(_,_), _, _, _).")

                        .context(PLANS_CONTEXT_SERVICE).build()).build().verify();

        System.out.println(verify);
        */


    }

    @Test
    public void test2() throws InvalidTheoryException {
        BeliefsContextService.getInstance().addInitialFact("full(10).");
        BeliefsContextService.getInstance().addInitialFact("full(N-1).");
        System.out.println( BeliefsContextService.getInstance().getTheory());
        System.out.println(BeliefsContextService.getInstance().verify("full(10)."));
    }
}
