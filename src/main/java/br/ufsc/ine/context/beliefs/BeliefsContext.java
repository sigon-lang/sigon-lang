package br.ufsc.ine.context.beliefs;

import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.prolog.PrologEnvironment;

public class BeliefsContext {

	private static BeliefsContext instance;
	private static PrologEnvironment prologEnvironment;

	private BeliefsContext() {

	}

	public static BeliefsContext getInstance() {
		return instance;
	}

	public static void startService() {
		instance = new BeliefsContext();
		prologEnvironment = new PrologEnvironment();
	}

	public void beliefs(List<Context> contexts) {
		List<String> clauses = contexts.stream()
			.map(c -> c.getClauses())
			.flatMap(l -> l.stream())
			.collect(Collectors.toList());
		
		clauses.forEach(c -> {
			appendFact(c);
		});
	}

	private void appendFact(String c) {
		try {
			prologEnvironment.appendFact(c);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
	}
	
	public boolean haveBelief(String desire) {
		SolveInfo solveGoal;
		try {
			solveGoal = prologEnvironment.solveGoal(desire);
			return solveGoal.isSuccess();
		} catch (MalformedGoalException e) {
			return false;
		}

	}

}
