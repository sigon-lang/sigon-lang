package br.ufsc.ine.agent.bridgerules;

import alice.tuprolog.*;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.utils.PrologEnvironment;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Ignore
public class BridgeRuleTest {

    ContextService intentionsContext;
    ContextService beliefsContext;
    ContextService desiresContext;
    ContextService plansContext;
    ContextService communicationContext;

    private static final String VARIABLE = "X.";
    private static final String LITERAL = "test.";

    @Before
    public void before(){
        this.intentionsContext  = IntentionsContextService.getInstance();
        this.beliefsContext  = BeliefsContextService.getInstance();
        this.desiresContext  = DesiresContextService.getInstance();
        this.plansContext = PlansContextService.getInstance();
        this.communicationContext = CommunicationContextService.getInstance();
    }

    @Test
    public void testPlanCompute() throws InvalidTheoryException, MalformedGoalException {
        String plan = "plan(position(10,10), [action(moveFront(_), \\+ position(10,_), position(_,_))], position(_,_), position(_,_)).";
        String belief = "position(0,0).";
        String desire = "position(10,10).";

        this.beliefsContext.appendFact(belief);
        this.desiresContext.appendFact(desire);
        this.plansContext.appendFact(plan);

        BridgeRule.builder()
                .head(Head.builder().context(communicationContext).clause("X").build())
                .body(Body.builder().context(plansContext).clause("plan(X, Z, _, _).")
                        .and(Body.builder().context(beliefsContext).notClause("X").build())
                        .and(Body.builder().context(desiresContext).clause("X").build())
                        .build())
                .build().execute();


       boolean verify =  CommunicationContextService.getInstance().verify("[action(moveFront(_), \\+ position(10,_), position(_,_))].");
       System.out.println(CommunicationContextService.getInstance().getTheory().toString());
       assertThat(verify, is(true));
    }

    @Test
    public void testWhitOnlyContextAndGenericVariable(){
        DesiresContextService.getInstance().appendFact(LITERAL);
        BeliefsContextService.getInstance().appendFact(LITERAL);
        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();

        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }

    @Test
    public void testAndMoreClausesGenericVariable(){
        DesiresContextService.getInstance().appendFact(LITERAL);
        DesiresContextService.getInstance().appendFact("test2.");


        Body beliefsBody = Body.builder().context(beliefsContext).notClause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
        assertThat(IntentionsContextService.getInstance().verify("test2."), is(true));
    }


    public void testFailWhitAndNotClauseGenericVariable(){
        BeliefsContextService.getInstance().appendFact(LITERAL);
        DesiresContextService.getInstance().appendFact(LITERAL);


        Body beliefsBody = Body.builder().context(beliefsContext).clause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).notClause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(false));
    }

    @Test
    public void testWhitAndNotClauseGenericVariable(){
        BeliefsContextService.getInstance().appendFact(LITERAL);

        Body beliefsBody = Body.builder().context(beliefsContext).clause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).notClause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }

    @Test
    public void testWhitAndClauseGenericVariable(){
        BeliefsContextService.getInstance().appendFact(LITERAL);
        DesiresContextService.getInstance().appendFact(LITERAL);

        Body beliefsBody = Body.builder().context(beliefsContext).clause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }


    @Test
    public void testWhitMoreCotextsAndOrGenericVariable(){
        BeliefsContextService.getInstance().appendFact(LITERAL);
        Body beliefsBody = Body.builder().context(beliefsContext).clause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .or(beliefsBody)
                .build();
        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }



    @Test
    public void testLiteralComputeInIntentionsContext(){
        DesiresContextService.getInstance().appendFact(LITERAL);

        Body beliefsBody = Body.builder().context(beliefsContext).notClause(LITERAL).build();
        Body ruleBody = Body.builder()
                .context(desiresContext).clause(LITERAL)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(LITERAL).build())
                .body(ruleBody).build();

        //sintetiza a intenção
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }

    // TODO: 2/24/18 testando
    @Test
    public void testFirstArgumentOrConnector(){
        DesiresContextService.getInstance().appendFact(LITERAL);
        //BeliefsContextService.getInstance().appendFact(LITERAL);

        Body beliefsBody = Body.builder().context(beliefsContext).notClause(VARIABLE).build();

        Body ruleBody = Body.builder()
                .context(desiresContext).clause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();

        //sintetiza a intenção
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }

    @Test
    public void testLastArgumentOrConnector(){
        DesiresContextService.getInstance().appendFact(LITERAL);
        Body beliefsBody = Body.builder().context(beliefsContext).clause(LITERAL).build();
        Body ruleBody = Body.builder()
                .context(desiresContext).clause(LITERAL)
                .or(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(LITERAL).build())
                .body(ruleBody).build();

        //sintetiza a intenção
        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(true));
    }
}
