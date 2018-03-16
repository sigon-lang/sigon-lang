package br.ufsc.ine.agent.context.beliefs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.Context;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

public class BeliefsContextService implements ContextService {

	private static BeliefsContextService instance = new BeliefsContextService();
	private static PrologEnvironment prologEnvironment;
	private List<Context> beliefs = new ArrayList<>();

	private BeliefsContextService() {
		prologEnvironment = new PrologEnvironment();
	}

	public static BeliefsContextService getInstance() {
		return instance;
	}



	public void beliefs(List<Context> beliefs) {
		this.beliefs = beliefs;
		List<String> clauses = beliefs.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		clauses.forEach(c -> {
			appendFact(c);
		});
	}



	public List<Context> getBeliefs() {
		return beliefs;
	}




	public void updateBelief(String literal) throws InvalidTheoryException {
		prologEnvironment.appendFact(literal);

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
	public void appendFact(String c) {
		try {
			prologEnvironment = new PrologEnvironment();
			prologEnvironment.appendFact(c);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Theory getTheory(){
		return prologEnvironment.getEngine().getTheory();
	}

	@Override
	public String getName() {
		return "bc";
	}
}
