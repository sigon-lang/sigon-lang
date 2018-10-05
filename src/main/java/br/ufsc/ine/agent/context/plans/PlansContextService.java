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
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlansContextService implements ContextService {

	private static PrologEnvironment prologEnvironment;
	public static PlansContextService instance = new PlansContextService();

	private PlansContextService() {
		prologEnvironment = new PrologEnvironment();
	}

	public static PlansContextService getInstance() {
		return instance;
	}

	private List<Plan> plans;
	private List<Action> actions = new ArrayList<>();

	public void plans(List<Plan> plans) {
		this.plans = plans;

	}

	public void addAction(Action a) {
		actions.add(a);
	}

	private boolean hasBelief(String clause) {

		return Body.builder().head(Head.builder().clause(clause).build()).context(BeliefsContextService.getInstance())
				.clause(clause).build().verify();
	}

	/*
	 * Construção através da busca: Para cada pós condição da ação, verificar se
	 * existe um plano com uma "intenção" aka something to be true que faça o match
	 * entre os dois. Dar uma olhada em planning. Desejos de negociação presicam ser
	 * adicionados por regras de ponte.
	 * 
	 * Disponivel as ações
	 */

	public void executePlanAlgorithm() {

		createPlan();

		// TODO: add intencao na verificacao para busca do plano

		Optional<Plan> plan = plans.stream()
				.filter(p -> !this.hasBelief(p.getSomethingToBeTrue()) && checkPreConditions(p)).findFirst();

		if (plan.isPresent()) {

			List<Action> actions = plan.get().getActions().stream().filter(actionPredicate)
					.collect(Collectors.toList());

			Collections.shuffle(actions);
			Optional<Action> any = actions.stream().findAny();
			if (any.isPresent()) {

				String args = any.get().getArguments().toString();
				args = args.replaceAll("[\\[\\]]", "");
				if (args.isEmpty()) {
					args = "_";
				}
				this.appendFact("act(" + any.get().getName() + "(" + args + ")" + ").");

				BridgeRule.builder()
						.head(Head.builder().context(CommunicationContextService.getInstance()).clause("X").build())
						.body(Body.builder().context(getInstance()).clause("act(X)").build()).build().execute();

			}
		}

	}

	private boolean checkPreConditions(Plan p) {
		if (p.getPreConditions().isEmpty()) {
			return true;
		}
		boolean check = false;
		for (String clause : p.getPreConditions()) {

			if (clause.startsWith("not")) {
				check = !hasBelief(clause.replace("not", ""));
			} else {
				check = hasBelief(clause);
			}

			if (check == false) {
				return check;
			}

		}
		return check;
	}

	//// TODO: 3/3/18 ver como tratar nots and e ord em clauses
	Predicate<Action> actionPredicate = new Predicate<Action>() {
		@Override
		public boolean test(Action action) {
			for (String clause : action.getPreConditions()) {

				if (clause.startsWith("not")) {
					return !hasBelief(clause.replace("not", ""));
				} else {
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
			if (c.trim().endsWith(").")) {
				StringBuilder builder = new StringBuilder();
				String toReplace = c.substring(c.indexOf("(") + 1, c.lastIndexOf(")"));
				Arrays.stream(toReplace.split(",")).map(i -> "_,").forEach(builder::append);
				StringBuilder test = new StringBuilder();
				test.append(c.substring(0, c.indexOf("(")));
				test.append("(");
				test.append(builder.toString().substring(0, builder.toString().length() - 1));
				test.append(").");
				toTest = test.toString();
				update = this.verify(toTest);
			}
			if (update) {
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
	public Theory getTheory() {
		return prologEnvironment.getEngine().getTheory();
	}

	@Override
	public String getName() {
		return "pc";
	}

	public void plansClauses(List<String> clauses) {
		clauses.forEach(this::appendFact);
	}

	/*
	 * Agente tem desejo X Regra de ponte define ações que são adicionadas no
	 * contexto de planejamento Para cada regra: Tentar achar uma ação que tem pós
	 * condição que satisfaça desejo X Dúvida: Como definir as pré-condições e pós
	 * condições do plano? Pós condição será desejo X satisfeito. Pré condição serão
	 * as mesmas das ações (por enquanto) Pesquisar nova abordagem!
	 * 
	 */

	public Set<Action> chooseActionsToSatisfyDesire(String somethingToBeTrue) {

		Set<Action> requiredAcions = new HashSet<Action>();
		List<Action> requiredActions = new ArrayList<>();
		// && verifyPreCondition(action.getPreConditions()

		for (Action action : actions) {
			if (action.getPosConditions().contains(somethingToBeTrue.replace(".", ""))
					&& verifyPreConditionFromBeliefContext(action.getPreConditions())) { // précondicao deve ser
																							// satisfeita
				requiredAcions.add(action);
			}
		}
		// n ações que satisfazem o plano
		/* Considerar as pós condicoes das ações como pré condição das ações? */
		// definir sequencia de acao - se acao n tem pré condicao que é pos condicao de
		// acao n-1,
		// entao adicionar em ordem

		// System.out.println("required actions "+requiredAcions.get(0).getName());

		return requiredAcions;

	}

	// preconditions é o alvo
	//
	public boolean verifyPreConditionFromActions(String preConditions, List<Action> actions) {
		int index = 0;
		List<Action> sortedActions = new ArrayList<>();
		Set<String> posCond = new HashSet<>();
		for (Action action : actions) {
			posCond = action.getPosConditions();
			if (posCond.contains(preConditions)) {
				// verifyPreCondition(action,sortedActions, actions, index);
			}
		}

		return true;
	}

	public void verifyPreCondition(Action goal, List<Action> sortedActions, List<Action> actions, int index) {

		if (verifyPreConditionFromBeliefContext(goal.getPreConditions())) {
			sortedActions.add(index, goal);

		} else {
			for (Action action : actions) {
				if (action.getPreConditions().contains(goal.getPosConditions().stream().findFirst().get())) {
					sortedActions.add(index, goal);
					index++;
					verifyPreCondition(goal, sortedActions, actions, index);
				}
			}
		}

	}

	public boolean verifyPreConditionFromBeliefContext(Set<String> preConditions) {
		/* Se tiver alguma preC não satisfeita, então a ação não pode ser executada. */
		for (String condition : preConditions) {
			if (!BeliefsContextService.getInstance().verify(condition + "."))
				return false;

		}
		return true;
	}

	public boolean verifyPosCondition(Set<String> posConditions) {

		/*
		 * verificar se uma pos condicao satisfaz o desejo por completo [a, b, c] pos
		 * condicao pode só tornar verdade o 'a', por exemplo
		 */

		return true;

	}

	public void createPlan() {

		String[] actionsPC = PlansContextService.getInstance().getTheory().toString().split("\n");
		String[] terms;
		/* Create instances of actions */
		for (String action : actionsPC) {
			if (action.contains("act(")) {

				Action a = new Action();
				terms = action.replace("act(", "").replaceAll("\\).", "").split(",");
				Set<String> pre = new HashSet<>();
				Set<String> pos = new HashSet<>();
				pre.add(terms[1]);
				pos.add(terms[2]);
				a.setName(terms[0]);
				a.setPreConditions(pre);
				a.setPosConditions(pos);
				actions.add(a);

			}
		}

		String[] somethingToBeTrue = DesiresContextService.getInstance().getTheory().toString().split("\n");
		for (String desire : somethingToBeTrue) {
			createSimplePlan(chooseActionsToSatisfyDesire(desire), desire);
		}

		System.out.println(plans.toString());

	}

	// the name was on purpose haha
	/*
	 * 
	 * */
	public void createSimplePlan(Set<Action> actions, String somethingToBeTrue) {
		Plan p = new Plan();
		p.setSomethingToBeTrue(somethingToBeTrue);
		if (actions.size() > 0) {
			Set<String> preConditions = new HashSet<>();
			Set<String> posConditions = new HashSet<>();
			p.setActions(actions);
			for (Action action : actions) {
				preConditions.addAll(action.getPreConditions());
				posConditions.addAll(action.getPosConditions());
			}
			p.setPreConditions(preConditions);
			p.setPosConditions(posConditions);

		}

		plans.add(p);

	}

	public void addPlan(Plan p) {
		this.plans.add(p);
	}
	/*
	 * public static void main(String[] args) { PlansContextService pc = new
	 * PlansContextService(); List<Plan> plans = new ArrayList<>(); List<Action>
	 * actions = new ArrayList<>();
	 * 
	 * Action a = new Action(); a.setName("action1"); Set<String> preC = new
	 * HashSet<>(); preC.add("t1");
	 * 
	 * Set<String> posC = new HashSet<>(); posC.add("aux");
	 * 
	 * a.setPreConditions(preC); a.setPosConditions(posC);
	 * 
	 * actions.add(a);
	 * 
	 * Plan p = new Plan(); p.setSomethingToBeTrue("aux"); plans.add(p);
	 * 
	 * pc.plans(plans);
	 * 
	 * Set<Action> chosenActions = pc.chooseActionsToSatisfyDesire(actions, "aux");
	 * pc.createSimplePlan(chosenActions, "aux");
	 * System.out.println(pc.plans.size()); for (Plan pl : pc.plans) {
	 * System.out.println("something to be true " + pl.getSomethingToBeTrue());
	 * System.out.println(pl.getPreConditions()); for (Action action :
	 * pl.getActions()) { System.out.println(action.getName()); }
	 * System.out.println(pl.getPosConditions()); }
	 * 
	 * }
	 */
}
