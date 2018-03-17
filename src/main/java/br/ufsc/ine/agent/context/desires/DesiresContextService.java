package br.ufsc.ine.agent.context.desires;

import java.util.List;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

public class DesiresContextService  implements ContextService{

	public static DesiresContextService ourInstance = new DesiresContextService();
	private static PrologEnvironment prologEnvironment;

	private DesiresContextService() {
		prologEnvironment = new PrologEnvironment();
	}

	public static DesiresContextService getInstance() {
		return ourInstance;
	}

	 
	public void desires(List<LangContext> langContexts) {
		langContexts.forEach(ctx -> {
			ctx.getClauses().forEach(clause -> {
				try {
					this.addInitialFact(clause);
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
	public Theory getTheory(){
		return prologEnvironment.getEngine().getTheory();
	}

	@Override
	public String getName() {
		return "dc";
	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);

	}

}
