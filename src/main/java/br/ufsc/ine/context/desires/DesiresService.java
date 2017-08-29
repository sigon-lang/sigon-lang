package br.ufsc.ine.context.desires;

import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.prolog.PrologEnvironment;

public class DesiresService {

	public static DesiresService instance;
	private static PrologEnvironment prologEnvironment;

	private DesiresService() {

	}

	public static void startService() {
		instance = new DesiresService();
		prologEnvironment = new PrologEnvironment();
	}

	public boolean haveDesire(String desire) {
		SolveInfo solveGoal;
		try {
			solveGoal = prologEnvironment.solveGoal(desire+".");
			return solveGoal.isSuccess();
		} catch (MalformedGoalException e) {
			return false;
		}

	}

	public static void desires(List<Context> contexts) {
		contexts.forEach(ctx -> {
			ctx.getClauses().forEach(clause -> {
				try {
					prologEnvironment.appendFact(clause);
				} catch (InvalidTheoryException e) {
					// TODO: logar erro
					e.printStackTrace();
				}
			});
		});
	}

}
