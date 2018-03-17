package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Ignore
public class StrongRealismTest {

    BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
    DesiresContextService desiresContext = DesiresContextService.getInstance();
    CommunicationContextService communicationContext = CommunicationContextService.getInstance();
    IntentionsContextService intentionsContext = IntentionsContextService.getInstance();

    @Test
    public void testStrongRealism(){

        //Regra 3
        //quando nao acredito, não posso desejar
        desiresContext.appendFact("r3test1.");
        assertThat(desiresContext.verify("r3test1."), is(false));
        //quando acredito posso desejar
        beliefsContext.appendFact("r3test2.");
        desiresContext.appendFact("r3test2.");
        assertThat(desiresContext.verify("r3test2."), is(true));

        //Regra 4
        //quando eu desejo eu acredito
        desiresContext.appendFact("r4test1.");
        System.out.println(desiresContext.getTheory().toString());

    }
}
