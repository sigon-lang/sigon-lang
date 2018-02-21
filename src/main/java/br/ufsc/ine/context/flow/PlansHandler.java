package br.ufsc.ine.context.flow;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.ufsc.ine.actuator.Actuator;
import br.ufsc.ine.bridge.Element;
import br.ufsc.ine.bridge.Rule;
import br.ufsc.ine.context.plans.Action;
import br.ufsc.ine.context.plans.Plan;
import br.ufsc.ine.context.plans.PlansContextService;

public class PlansHandler extends ContextHandler {

	Predicate<Action> actionPredicate = new Predicate<Action>() {
		@Override
		public boolean test(Action action) {
			for (String clause : action.getPreConditions()) {

				if(clause.startsWith("not")){
					return !buildBeliefsRule(clause.replace("not", "")).execute();
				} else{
					return buildBeliefsRule(clause).execute();
				}


			}
			return true;
		}
	};

	@Override
	public void handleRequest(String literal) {

		System.out.println(literal);

		//TODO: ver uma forma de melhorar
		List<Actuator> actuators = PlansContextService.getInstance().getActuators();

		List<Plan> plans = PlansContextService.getInstance().getPlans();


		plans.stream().filter(p -> !this.buildBeliefsRule(p.getSomethingToBeTrue()).execute()).forEach(p -> {
			List<Action> actions = p.getActions().stream().filter(actionPredicate).collect(Collectors.toList());
			System.out.println("Executar plano");
			Collections.shuffle(actions);
			Optional<Action> any = actions.stream().findAny();
			if (any.isPresent()) {
				System.out.println("Executar: " + any.get().getName());
				Actuator actuator = actuators.stream().filter(a -> a.getName().equals(any.get().getName())).findFirst().get();
				actuator.act(null);
			}

		});

		if (super.successor != null) {
			super.successor.handleRequest(literal);
		}
	}

	private Rule buildBeliefsRule(String variable) {
		Element predicates = new Element();
		predicates.setContext("beliefs");

		Rule rule = new Rule();
		rule.setVerify(variable + ".");
		rule.setIn(predicates);

		//return Rule.builder().verify(variable + ".").in(predicates).build();
		return rule;
	}

}
