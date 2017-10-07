package br.ufsc.ine.context.beliefs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.ContextService;
import br.ufsc.ine.prolog.PrologEnvironment;

public class BeliefsContextService implements ContextService {

	private static BeliefsContextService instance;
	private static PrologEnvironment prologEnvironment;
	private List<Context> beliefs = new ArrayList<>();

	private BeliefsContextService() {

	}

	public static BeliefsContextService getInstance() {
		return instance;
	}

	public static void startService() {
		instance = new BeliefsContextService();
		prologEnvironment = new PrologEnvironment();
	}

	public void beliefs(List<Context> beliefs) {
		this.beliefs = beliefs;
		List<String> clauses = beliefs.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())
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

	public List<Context> getBeliefs() {
		return beliefs;
	}

	// TODO: add na lista de beliefs
	public void addBelief(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);

	}

	//TODO: ver como atualizar para nao precisa recriar a base
	public void updateBelief(String literal) throws InvalidTheoryException {
		prologEnvironment = new PrologEnvironment();
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

}
