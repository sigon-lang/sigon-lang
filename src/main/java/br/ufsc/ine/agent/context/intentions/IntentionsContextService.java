package br.ufsc.ine.agent.context.intentions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.utils.PrologEnvironment;

public class IntentionsContextService implements ContextService {

	public static IntentionsContextService instance = new IntentionsContextService();
	private static PrologEnvironment prologEnvironment;
	private List<LangContext> intentions = new ArrayList<>();

	private IntentionsContextService() {
		prologEnvironment = new PrologEnvironment();
	}



	public static IntentionsContextService getInstance() {
		return instance;
	}
	
	public void intentions(List<LangContext> intentions) {
		this.intentions = intentions;
		List<String> clauses = intentions.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())

				.collect(Collectors.toList());

		clauses.forEach(clause -> {
			this.addInitialFact(clause);
		});

	}

	public void checkIntentions(List<LangContext> desires) {

		List<String> clauses = desires.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		clauses.forEach(d -> {
			if (!BeliefsContextService.getInstance().verify(d)) {
				try {
					prologEnvironment.appendFact(d);

				} catch (InvalidTheoryException e) {
					e.printStackTrace();
				}
			}
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
		return "ic";
	}

	@Override
	public void addInitialFact(String fact) {
		try {
			prologEnvironment.appendFact(fact);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
	}
}
