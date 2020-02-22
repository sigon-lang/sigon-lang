package br.ufsc.ine.agent.context.beliefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.utils.PrologEnvironment;

public class BeliefsContextService implements ContextService {

	private static BeliefsContextService instance = new BeliefsContextService();
	private static PrologEnvironment prologEnvironment;
	private List<LangContext> beliefs = new ArrayList<>();

	private BeliefsContextService() {
		prologEnvironment = new PrologEnvironment();
	}

	public static BeliefsContextService getInstance() {
		return instance;
	}

	public void beliefs(List<LangContext> beliefs) {
		this.beliefs = beliefs;
		List<String> clauses = beliefs.stream().map(c -> c.getClauses()).flatMap(l -> l.stream())

				.collect(Collectors.toList());

		clauses.forEach(clause -> {
			try {
				this.addInitialFact(clause);
			} catch (InvalidTheoryException e) {
				e.printStackTrace();
			}
		});

	}

	public int size() {
		return prologEnvironment.getSize();
	}

	public List<LangContext> getBeliefs() {
		return beliefs;
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
		// TODO: refactor code (This may appear in other place).
		if (c.startsWith("-")) {
			c = c.replace("-", "").trim();
			Agent.removeBelief = true;
		}
		if (Agent.removeBelief) {
			Agent.removeBelief = false;
			try {
				prologEnvironment.removeFact(c);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		try {
			boolean update = true;
			String toTest = null;

			if (c.trim().endsWith(").")) {
				String predicado = c.substring(0, c.indexOf("(") + 1);
				// String[] toReplace = c.substring(c.indexOf("(") + 1,
				// c.lastIndexOf(")")).split(",");

				// ArrayList<String> possibilidades = new ArrayList<String>();
				StringBuilder test = new StringBuilder();
				String toReplace = c.substring(c.indexOf("(") + 1, c.lastIndexOf(")"));
				StringBuilder builder = new StringBuilder();
				Arrays.stream(toReplace.split(",")).map(i -> "_,").forEach(builder::append);
				test.append(c.substring(0, c.indexOf("(")));
				test.append("(");
				test.append(builder.toString().substring(0, builder.toString().length() - 1));
				test.append(").");
				toTest = test.toString();
				if (!this.verify(toTest)) {
					prologEnvironment.appendFact(c);
				} else {
					// TODO

					String[] args = toReplace.split(",");
					String currentTest, previousTest;
					previousTest = predicado + args[0];
					for (int i = 1; i < args.length-1; i++) {
						currentTest = previousTest;
						for (int j = i; j < args.length; j++) {
							currentTest += ",_";
						}
						currentTest += ").";
						previousTest += "," + args[i];
						if (!this.verify(currentTest)) {
							prologEnvironment.appendFact(c);
							update = false;
							break;
						}

					}
					if(update) {
						prologEnvironment.updateFact(c, previousTest+",_).");
					}

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public Theory getTheory() {
		return prologEnvironment.getEngine().getTheory();
	}

	@Override
	public String getName() {
		return "bc";
	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);
	}
}
