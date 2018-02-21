package br.ufsc.ine.agent.context.desires;

import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.Context;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

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

	@Override
	public void appendFact(String c) {
		try {
			prologEnvironment.appendFact(c);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
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

	@Override
	public Theory getAllFacts(){
		return prologEnvironment.getEngine().getTheory();
	}

}
