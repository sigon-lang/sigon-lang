package br.ufsc.ine.prolog;

import org.junit.Assert;
import org.junit.Test;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;

public class PrologEnvironmentTest {

	private PrologEnvironment prologEnvironment;

	@Test
	public void socratesIsMortal() throws InvalidTheoryException, MalformedGoalException {
		prologEnvironment = new PrologEnvironment();
		prologEnvironment.appendFact("humano(socrates).");
		prologEnvironment.appendFact("mortal(X) :- humano(X).");
		SolveInfo solveInfo = prologEnvironment.solveGoal("mortal(socrates).");
		Assert.assertEquals(Boolean.TRUE, solveInfo.isSuccess());
	}

	@Test
	public void socratesIsNotMortal() throws InvalidTheoryException, MalformedGoalException {
		prologEnvironment = new PrologEnvironment();
		prologEnvironment.appendFact("alien(socrates).");
		prologEnvironment.appendFact("mortal(X) :- humano(X).");
		SolveInfo solveInfo = prologEnvironment.solveGoal("mortal(socrates).");
		Assert.assertEquals(Boolean.FALSE, solveInfo.isSuccess());
	}

}
