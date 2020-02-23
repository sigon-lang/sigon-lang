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
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.context.bayesian.BayesianContextService;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.Arrays;
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
	
	public boolean hasIntention(String somethingToBeTrue) {
		return Body.builder()
				.head(Head.builder().clause(somethingToBeTrue).build())
				.context(IntentionsContextService.getInstance())
				.clause(somethingToBeTrue).build()
				.verify();
		//return true;
	}
	
	public boolean hasPreCondition(String clause) {
		return clause.contains("aware(") && !BayesianContextService.getInstance().queryAwareNode(); //deve notificar apenas quando o queryAwareNode for false -> belief é menor que o threshhold
	}
	
	public boolean checkPreConditionsCustom(Plan p) {
		if(p.getPreConditions().isEmpty()) {
			return true;
		}
		boolean check = true;
		for(String clause : p.getPreConditions()){
			if(clause.startsWith("aware(")) {
				if(clause.startsWith("not")){
					check =  !hasPreCondition(clause.replace("not", ""));
				} else{
					check =  hasPreCondition(clause);
				}

				if(!check){
					return  check;
				}				
			}
			

		}
		return check;

	}
    public void executePlanAlgorithm() {
    	
		//TODO: add intencao na verificacao para busca do plano


		Optional<Plan> plan = plans.stream()
				.filter(p -> (this.hasIntention(p.getSomethingToBeTrue())) && (checkPreConditions(p) && this.checkPreConditionsCustom(p)))
				.findFirst();
		
		if(plan.isPresent()) {

			List<Action> actions = plan.get().getActions().stream().filter(actionPredicate).collect(Collectors.toList());

			Collections.shuffle(actions);
			Optional<Action> any = actions.stream().findAny();
			if (any.isPresent()) {
				
				String args =  any.get().getArguments().toString();
				args = args.replaceAll("[\\[\\]]", "");
				if(args.isEmpty()) {
					args = "_";
				}
 				this.appendFact("act(" + any.get().getName() + "(" + args +  ")" + ").");
				
				BridgeRule.builder()
						.head(Head.builder().context(CommunicationContextService.getInstance()).clause("X").build())
						.body(Body.builder().context(getInstance()).clause("act(X)").build()).build()
						.execute();

			}
		}
		
    }

	private boolean checkPreConditions(Plan p) {
		if(p.getPreConditions().isEmpty()) {
			return true;
		}
		boolean check = false;
		for(String clause : p.getPreConditions()){
			if(!clause.startsWith("aware(")) {
				if(clause.startsWith("not")){
					check =  !hasBelief(clause.replace("not", ""));
				} else{
					check =  hasBelief(clause);
				}

				if(!check){
					return  check;
				}

				
			}

			

		}
		return check;
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
			boolean update = false;
			String toTest = null;
			if(c.trim().endsWith(").")){
				StringBuilder builder = new StringBuilder();
				String toReplace = c.substring(c.indexOf("(")+1, c.lastIndexOf(")"));
				Arrays.stream(toReplace.split(",")).map(i-> "_,").forEach(builder::append);
				StringBuilder test = new StringBuilder();
				test.append(c.substring(0, c.indexOf("(")));
				test.append("(");
				test.append(builder.toString().substring(0,builder.toString().length()-1));
				test.append(").");
				toTest = test.toString();
				update = this.verify(toTest);
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
	public void addInitialFact(String c) {
		try {
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

    public void plansClauses(List<String> clauses) {
		clauses.forEach(this::appendFact);
    }
}
