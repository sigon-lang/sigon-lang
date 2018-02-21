package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BridgeRuleTest {

    private static final String VARIABLE = "X";
    private static final String LITERAL = "test.";

    //@Test
    public void testWhitVariable(){
        ContextService intentionsContext  = IntentionsContextService.getInstance();
        ContextService beliefsContext  = BeliefsContextService.getInstance();
        ContextService desiresContext  = DesiresContextService.getInstance();

        Body beliefsBody = Body.builder().context(beliefsContext).notClause(VARIABLE).build();

        Body ruleBody = Body.builder().context(desiresContext).clause(VARIABLE)
                .and(beliefsBody)
                .build();

        BridgeRule.builder()
                .head(Head.builder().context(intentionsContext).clause(VARIABLE).build())
                .body(ruleBody);
    }

    @Test
    public void testLiteralComputeInIntentionsContext(){
        IntentionsContextService.startService();
        BeliefsContextService.startService();
        DesiresContextService.startService();

        ContextService intentionsContext = IntentionsContextService.getInstance();
        ContextService beliefsContext = BeliefsContextService.getInstance();
        ContextService desiresContext = DesiresContextService.getInstance();

        //possui o desejo mas nao tem a intenção
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
}
