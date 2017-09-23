package br.ufsc.ine.context.intentions;

import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsContext;
import br.ufsc.ine.prolog.PrologEnvironment;

public class IntentionsContext {

	public static IntentionsContext instance;
	private static PrologEnvironment prologEnvironment;

	private IntentionsContext() {

	}

	public static void startService() {
		instance = new IntentionsContext();
		prologEnvironment = new PrologEnvironment();
	}

	public static IntentionsContext getInstance() {
		return instance;
	}

	public void checkIntentions(List<Context> desires) {

		List<String> clauses = desires.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())
				.collect(Collectors.toList());

		clauses.forEach(d -> {
			if (!BeliefsContext.getInstance().haveBelief(d)) {
				try {
					prologEnvironment.appendFact(d);
					System.out.println(d);
				} catch (InvalidTheoryException e) {
					e.printStackTrace();
				}
			}
		});

	}

}
