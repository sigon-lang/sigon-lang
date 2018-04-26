package br.ufsc.ine.br.ufsc.ine.agent.context.beliefs;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import org.junit.Test;

public class BeliefsContextServiceTest {

    @Test
    public void updateBelief(){
        BeliefsContextService.getInstance().appendFact("p(1,1).");
        BeliefsContextService.getInstance().appendFact("test.");
        //BeliefsContextService.getInstance().appendFact("p(2,1).");
        System.out.println(BeliefsContextService.getInstance().getTheory().toString());

    }
}
