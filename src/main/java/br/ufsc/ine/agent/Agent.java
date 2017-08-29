package br.ufsc.ine.agent;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsService;
import br.ufsc.ine.context.desires.DesiresService;
import br.ufsc.ine.context.plans.PlansService;
import io.reactivex.Flowable;

public class Agent {

	private static final String DESIRES = "desires";
	private static final Object BELIEFS = "beliefs";
	private static final Object PLANS = "plans";

	public void run(ContextWalker walker) {

		List<Context> beliefs = walker.getContexts().stream().filter(c -> c.getName().equals(BELIEFS))
				.collect(Collectors.toList());

		List<Context> desires = walker.getContexts().stream().filter(c -> c.getName().equals(DESIRES))
				.collect(Collectors.toList());

		List<Context> plans = walker.getContexts().stream().filter(c -> c.getName().equals(PLANS))
				.collect(Collectors.toList());

		// BeliefsService.start();
		// DesiresService.start();

		Flowable.just(beliefs).subscribe(BeliefsService::println);
		Flowable.just(desires).subscribe(DesiresService::println);
		Flowable.just(plans).subscribe(PlansService::println);

	}

}
