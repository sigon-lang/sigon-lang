package br.ufsc.ine.context.desires;

import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.ContextService;
import br.ufsc.ine.prolog.PrologEnvironment;

public class DesiresContextService  implements ContextService{

	public static DesiresContextService instance;
	private static PrologEnvironment prologEnvironment;

	private DesiresContextService() {

	}

	public static void startService() {
		instance = new DesiresContextService();
		prologEnvironment = new PrologEnvironment();
	}

	public static DesiresContextService getInstance() {
		return instance;
	}

	 
	public void desires(List<Context> contexts) {
		contexts.forEach(ctx -> {
			ctx.getClauses().forEach(clause -> {
				try {
					prologEnvironment.appendFact(clause);
				} catch (InvalidTheoryException e) {
					e.printStackTrace();
				}
			});
		});
	}

	public void addDesire(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);

	}

	@Override
	public boolean verify(String fact) {
		SolveInfo solveGoal;
		try {
			solveGoal = prologEnvironment.solveGoal(fact);
			return solveGoal.isSuccess();
		} catch (MalformedGoalException e) {
			return false;
		}
	}

}
