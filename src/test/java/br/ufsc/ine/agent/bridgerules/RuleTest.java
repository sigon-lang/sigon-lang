package br.ufsc.ine.agent.bridgerules;

import org.junit.Test;

import alice.tuprolog.InvalidTheoryException;

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
		//Body predicates = Body.builder().context("desires").type("prop")
		//		.and(Body.builder().context("beliefs").type("prop").build()).build();

		//return Rule.builder().verify(variable).in(predicates).build();
		return null;
	}

}
