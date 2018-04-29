package br.ufsc.ine.agent.bridgerules;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.UnknownVarException;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.utils.PrologEnvironment;
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
    IntentionsContextService intentionsContextService = IntentionsContextService.getInstance();

    @Test
    public void prologTest() throws MalformedGoalException, InvalidTheoryException, UnknownVarException, NoSolutionException {
        PrologEnvironment prolog = new PrologEnvironment();
        //prolog.appendFact("full(0).");
       // prolog.appendFact("G :- full(G).");
        prolog.appendFact("clear(N) :- N == 0.");

        System.out.println(prolog.getEngine().getTheory().toString());
        //System.out.println(prolog.getEngine().solve("G>0.").getTerm("G"));
        System.out.println(prolog.solveGoal("clear(1).").isSuccess());
    }


    @Test
    public void testaExemplo(){

    }

    @Test
    public void testaRegraParaStrongRealism(){

        plansContext .getInstance().appendFact("plan(test,_,[clear,x(_)],_). ");
        plansContext .getInstance().appendFact("plan(test1,_,[test,x(_)],_). ");
        communicationContext.appendFact("sense(clear).");
        desiresContext.appendFact("test.");
        desiresContext.appendFact("test1.");


        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
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

    private BridgeRule getBridgeRule1StrongRealism() {
        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plans(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();

        body.setAnd(plan);
        plan.setAnd(planMember);
        planMember.setAnd(desires);

        return BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build();

    }


    @Test
    public void atualizacaoCrencas(){

        BeliefsContextService.getInstance().appendFact("\\+clear.");
        BeliefsContextService.getInstance().appendFact("clear.");
        BeliefsContextService.getInstance().appendFact("garbage.");

        System.out.println(BeliefsContextService.getInstance().getTheory());
    }


    @Test
    public void testaRegraParaStrongRealism2(){

        plansContext .getInstance().appendFact("plan(check(slots),_,[(\\+ garbage),garbage,(\\+ clear),clear],_)."+System.lineSeparator());
        plansContext .getInstance().appendFact("plan(check(slots),_,[(\\+ garbage),garbage,(\\+ clear),clear],_).");
        communicationContext.appendFact("sense(garbage).");
        desiresContext.appendFact("check(slots).");


        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
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
    public void testaCrenca(){
        BeliefsContextService.getInstance().appendFact("at(P) :- pos(P, X, Y) , pos(r1, X, Y).");
        BeliefsContextService.getInstance().appendFact("pos(1, 3, 3).");
        BeliefsContextService.getInstance().appendFact("pos(r1, 3, 3).");

        BridgeRule.builder().head(Head.builder().clause("P").context(DesiresContextService.getInstance()).build())
                .body(Body.builder().context(BeliefsContextService.getInstance()).clause("at(P)").build())
        .build().execute();
        System.out.println(DesiresContextService.getInstance().getTheory().toString());
    }

    @Test
    public void teste1(){
        communicationContext.appendFact("sense(p(1,2)).");
        Head head = Head.builder().context(beliefsContext).clause("test(X, Y)").build();
        Body body = Body.builder().context(communicationContext).clause("sense(p(X,Y))").build();
        BridgeRule.builder().head(head).body(body).build().execute();
        System.out.println(beliefsContext.getTheory().toString());
    }


    @Test
    public void testaRegras(){
        communicationContext.appendFact("sense(breeze).");
        beliefsContext.appendFact("pos(1,1).");

        Head head =  Head.builder().context(beliefsContext).clause("breeze(X,Y)").build();
        Body body = Body.builder().context(communicationContext).clause("sense(breeze)")
                .and(Body.builder().context(beliefsContext).clause("pos(X,Y)").build()).build();
        BridgeRule.builder().head(head).body(body).build().execute();

        System.out.println(beliefsContext.getTheory().toString());
    }

    @Test
    public void testaRegrasNegacao(){
        //beliefsContext.appendFact("pos(1,1).");
      // beliefsContext.appendFact("\\+ sense(breeze).");
      // beliefsContext.appendFact("sense(breeze).");
       //beliefsContext.appendFact("\\+ sense(breeze).");

        //beliefsContext.appendFact("teste.");
       // beliefsContext.appendFact("position(0,0).");

        //beliefsContext.appendFact("\\+ garbage.");
        //beliefsContext.appendFact("garbage.");
        //beliefsContext.appendFact("\\+ garbage.");

       // beliefsContext.appendFact("-test.");

       // beliefsContext.appendFact("teste.");
        //beliefsContext.appendFact("\\+ teste.");

     ///   beliefsContext.appendFact("pos(1,1).");

       /// Head head =  Head.builder().context(beliefsContext).clause("~breeze(X,Y)").build();
       // Body body = Body.builder().context(communicationContext).clause("sense(breeze)")
       //         .and(Body.builder().context(beliefsContext).clause("pos(X,Y)").build()).build();
       // BridgeRule.builder().head(head).body(body).build().execute();

        System.out.println(beliefsContext.getTheory().toString());
    }









}
