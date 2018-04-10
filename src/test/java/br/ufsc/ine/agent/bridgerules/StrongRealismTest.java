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
    PlansContextService plansContext = PlansContextService.getInstance();

    @Test
    public void testaRegraParaStrongRealism(){

        plansContext .getInstance().appendFact("plans(test,_,[p(_),x(_)],_).");
        communicationContext.appendFact("sense(p(1)).");
        desiresContext.appendFact("test.");


        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plans(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();


        body.setAnd(plan);
        plan.setAnd(planMember);
        planMember.setAnd(desires);


        BridgeRule r2 = BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build();

        r2.execute();

        System.out.println(beliefsContext.getTheory().toString());

    }


    @Test
    public void testaRegras(){
        communicationContext.appendFact("sense(breeze).");
        beliefsContext.appendFact("pos(1,1).");

        Head head =  Head.builder().context(beliefsContext).clause("breeze(X,Y)").build();
        Body body = Body.builder().context(communicationContext).clause("sense(breeze)").and(Body.builder().context(beliefsContext).clause("pos(X,Y)").build()).build();
        BridgeRule.builder().head(head).body(body).build().execute();

        System.out.println(beliefsContext.getTheory().toString());
    }









}
