package br.ufsc.ine.context.intentions;

import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsContextService;
import br.ufsc.ine.prolog.PrologEnvironment;

public class IntentionsContextService {

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

}
