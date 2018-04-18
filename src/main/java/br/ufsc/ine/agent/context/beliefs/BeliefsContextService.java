package br.ufsc.ine.agent.context.beliefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.ContextService;
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
		try {
			boolean update = false;
			String toTest = null;

			if(c.trim().endsWith(").")){
				StringBuilder builder = new StringBuilder();
				String toReplace = c.substring(c.indexOf("(")+1, c.lastIndexOf(")"));
				Arrays.stream(toReplace.split(",")).map( i-> "_,").forEach(builder::append);
				StringBuilder test = new StringBuilder();
				test.append(c.substring(0, c.indexOf("(")));
				test.append("(");
				test.append(builder.toString().substring(0,builder.toString().length()-1));
				test.append(").");
				toTest = test.toString();

					update = (c.startsWith("\\+") && this.verify("\\+" + toTest))
							|| (!c.startsWith("\\+") && this.verify("\\+" + toTest))
							|| this.verify(toTest.replace("\\+", ""));


			}

            if(update){
                prologEnvironment.updateFact(c, toTest);
            } else {
                prologEnvironment.appendFact(c);
            }
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

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		prologEnvironment.appendFact(fact);
	}
}
