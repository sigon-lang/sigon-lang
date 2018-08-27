package br.ufsc.ine.br.ufsc.ine.agent.context.beliefs;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BeliefsContextServiceTest {

    @Test
    public void propAndFolFacts(){
    	BeliefsContextService bc = BeliefsContextService.getInstance();
        bc.appendFact("p(1,1).");
        bc.appendFact("test.");
        assertEquals(2, bc.size());
        //BeliefsContextService.getInstance().appendFact("p(2,1).");
        //System.out.println(BeliefsContextService.getInstance().getTheory().toString());

    }
}
