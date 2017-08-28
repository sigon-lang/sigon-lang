package br.ufsc.ine.agent;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsService;
import br.ufsc.ine.context.desires.DesiresService;
import io.reactivex.Flowable;

public class Agent {

	private static final String DESIRES = "desires";
	private static final Object BELIEFS = "beliefs";

	public void run(ContextWalker walker) {

		List<Context> beliefs = walker.getContexts().stream().filter(c -> c.getType().equals(BELIEFS))
				.collect(Collectors.toList());
		
		List<Context> desires = walker.getContexts().stream().filter(c -> c.getType().equals(DESIRES))
				.collect(Collectors.toList());
		
		//BeliefsService.start();
		//DesiresService.start();
		
		Flowable.just(beliefs).subscribe(BeliefsService::println);
		Flowable.just(desires).subscribe(DesiresService::println);

		walker.getContexts().forEach(ctx -> {
			System.out.println("Context: " + ctx.getName() + ", type: " + ctx.getType());
			ctx.getClauses().forEach(System.out::println);
		});

	}

}
