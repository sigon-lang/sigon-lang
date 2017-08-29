package br.ufsc.ine.context.plans;

import java.util.List;

import br.ufsc.ine.context.Context;

public class PlansService {

	public static void println(List<Plan> plans) {
		plans.forEach(ctx -> {
			ctx.getFunctions().forEach(System.out::println);
		});
	}

}
