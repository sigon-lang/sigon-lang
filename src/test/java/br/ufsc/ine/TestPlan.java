package br.ufsc.ine;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import org.junit.Test;

public class TestPlan {



    @Test
    public void test() throws InvalidTheoryException {
        BeliefsContextService.getInstance().addInitialFact("position(0,0).");
        BeliefsContextService.getInstance().addInitialFact("position(0,0).");
        boolean verify  = Body.builder()
                .head(Head.builder().clause("position(_,10).").build())
                .context(BeliefsContextService.getInstance())
                .clause("position(_,10).").build()
                .verify();
       // System.out.println(BeliefsContextService.getInstance().getTheory());
        //System.out.println(BeliefsContextService.getInstance().verify("p(10,10)."));
        System.out.println(!verify);
    }
}
