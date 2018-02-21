package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BridgeRuleTest {

    ContextService intentionsContext;
    ContextService beliefsContext;
    ContextService desiresContext;

    private static final String VARIABLE = "X.";
    private static final String LITERAL = "test.";

    @Before
    public void before(){
        IntentionsContextService.startService();
        BeliefsContextService.startService();
        DesiresContextService.startService();

        this.intentionsContext  = IntentionsContextService.getInstance();
        this.beliefsContext  = BeliefsContextService.getInstance();
        this.desiresContext  = DesiresContextService.getInstance();
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

    @Test
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
    public void failWhitMoreCotextsAndOrGenericVariable(){

        Body beliefsBody = Body.builder().context(beliefsContext).clause(VARIABLE).build();
        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .or(beliefsBody)
                .build();

        BridgeRule intentionsRule = BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody).build();

        intentionsRule.execute();
        boolean haveIntention = IntentionsContextService.getInstance().verify(LITERAL);
        assertThat(haveIntention, is(false));
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


    @Test
    public void testFirstArgumentOrConnector(){
        DesiresContextService.getInstance().appendFact(LITERAL);

        Body beliefsBody = Body.builder().context(beliefsContext).clause(LITERAL).build();
        Body ruleBody = Body.builder()
                .context(desiresContext).clause(LITERAL)
                .or(beliefsBody)
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
