package br.ufsc.ine.br.ufsc.ine.agent.context.beliefs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;

public class BeliefsContextServiceTest {

    @Test
    public void propAndFolFacts(){
    	BeliefsContextService bc = BeliefsContextService.getInstance();
        bc.appendFact("p(1,1).");
        bc.appendFact("test.");
        assertEquals(2, bc.size());
        
        bc.appendFact("-p(1,1).");
        assertEquals(1, bc.size());
        bc.appendFact("a:-b.");
        assertEquals(2, bc.size());
        

    }
}
