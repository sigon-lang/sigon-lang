package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import org.junit.Test;

public class TestAspect {

    @Test
    public void testContextAspect(){
        String fact = "position(10,10).";
        BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
        DesiresContextService desiresContext = DesiresContextService.getInstance();
        beliefsContext.appendFact(fact);
        desiresContext.appendFact(fact);

        //beliefsContext.appendFact(fact);
        //beliefsContext.appendFact("test.");

        System.out.println(desiresContext.getTheory().toString());

    }

}
