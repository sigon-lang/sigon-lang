package br.ufsc.ine;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import org.junit.Test;

public class TestPlan {



    @Test
    public void test() throws InvalidTheoryException {

        DesiresContextService.getInstance().addInitialFact("position(0,0).");

        BridgeRule.builder()
                .head(Head.builder().context(BeliefsContextService.getInstance()).clause("possible(X).").build())
                .body(Body.builder().context(DesiresContextService.getInstance()).clause("X").build())
                .build().execute();

        System.out.println(BeliefsContextService.getInstance().getTheory().toString());
    }
}
