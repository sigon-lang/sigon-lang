package br.ufsc.ine.agent.flow;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
				if (!buildBeliefsRule(clause).execute()) {
					return false;
				}
			}
			return true;
		}
	};

	@Override
	public void handleRequest(String literal) {

		List<Plan> plans = PlansContextService.getInstance().getPlans();

		plans.stream().filter(p -> !this.buildBeliefsRule(p.getSomethingToBeTrue()).execute()).forEach(p -> {

			Optional<Action> any = p.getActions().stream().filter(actionPredicate).findAny();
			if (any.isPresent()) {
				System.out.println("Executar: " + any.get().getName());
			}

			p.getActions().forEach(action -> {
				action.getPreConditions().forEach(pre -> {

				});
			});

		});

		if (super.successor != null) {
			super.successor.handleRequest(literal);
		}
	}

	private Rule buildBeliefsRule(String variable) {
		Element predicates = Element.builder().context("beliefs").build();
		return Rule.builder().verify(variable + ".").in(predicates).build();
	}

}