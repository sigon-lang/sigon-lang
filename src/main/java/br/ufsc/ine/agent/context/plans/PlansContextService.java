package br.ufsc.ine.agent.context.plans;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.Actuator;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlansContextService implements ContextService{

	private static PrologEnvironment prologEnvironment;
	public static PlansContextService instance = new PlansContextService();


	private PlansContextService() {
		prologEnvironment = new PrologEnvironment();
	}

	public static PlansContextService getInstance() {
		return instance;
	}
	
	private List<Plan> plans;

	public void plans(List<Plan> plans) {
		this.plans = plans;
		
	}

	private boolean hasBelief(String clause){
		return Body.builder()
				.head(Head.builder().clause(clause).build())
				.context(BeliefsContextService.getInstance())
				.clause(clause).build()
				.verify();
	}

    public void executePlanAlgorithm() {

		//TODO: add intencao na verificacao para busca do plano
		//TODO: buscar o primeiro plano
		plans.stream().filter(p -> !this.hasBelief(p.getSomethingToBeTrue())).forEach(p -> {




			List<Action> actions = p.getActions().stream().filter(actionPredicate).collect(Collectors.toList());

			Collections.shuffle(actions);
			Optional<Action> any = actions.stream().findAny();
			if (any.isPresent()) {

				// TODO: 3/3/18 add argumentos da funcao
				this.appendFact("act("+any.get().getName()+").");

				BridgeRule.builder()
						.head(Head.builder().context(CommunicationContextService.getInstance()).clause("X").build())
						.body(Body.builder().context(getInstance()).clause("act(X)").build()).build()
						.execute();

			}

		});
		
    }

    //// TODO: 3/3/18 ver como tratar nots and e ord em clauses
    Predicate<Action> actionPredicate = new Predicate<Action>() {
		@Override
		public boolean test(Action action) {
			for (String clause : action.getPreConditions()) {

				if(clause.startsWith("not")){
					return !hasBelief(clause.replace("not", ""));
				} else{
					return hasBelief(clause);
				}


			}
			return true;
		}
	};

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
		    //// TODO: 3/3/18 ver uma forma para melhorar isso, ao dar new add teoria de plans 
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
		return "pc";
	}
}
