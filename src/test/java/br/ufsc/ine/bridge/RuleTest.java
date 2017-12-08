package br.ufsc.ine.bridge;

import static org.junit.Assert.*;

import org.junit.Test;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.context.beliefs.BeliefsContextService;
import br.ufsc.ine.context.desires.DesiresContextService;

public class RuleTest {

	@Test
	public void testBridgeRule() throws InvalidTheoryException {

//		BeliefsContextService.startService();
//		DesiresContextService.startService();
		
//		BeliefsContextService.getInstance().addBelief("position(1,1).");
//		DesiresContextService.getInstance().addDesire("position(1,1).");
	
		//Rule rule = buildRule("position(1,1).");
		//assertTrue(rule.execute());

	}

	private Rule buildRule(String variable) {
		//Element predicates = Element.builder().context("desires").type("prop")
		//		.and(Element.builder().context("beliefs").type("prop").build()).build();

		//return Rule.builder().verify(variable).in(predicates).build();
		return null;
	}

}
