package br.ufsc.ine.agent.context.intentions;

import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import br.ufsc.ine.agent.context.Context;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.utils.PrologEnvironment;

public class IntentionsContextService implements ContextService {

	public static IntentionsContextService instance;
	private static PrologEnvironment prologEnvironment;

	private IntentionsContextService() {

	}

	public static void startService() {
		instance = new IntentionsContextService();
		prologEnvironment = new PrologEnvironment();
	}

	public static IntentionsContextService getInstance() {
		return instance;
	}

	public void checkIntentions(List<Context> desires) {

		List<String> clauses = desires.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		clauses.forEach(d -> {
			if (!BeliefsContextService.getInstance().verify(d)) {
				try {
					prologEnvironment.appendFact(d);
					System.out.println(d);
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
}
