package br.ufsc.ine.context.plans;

import java.util.List;

import br.ufsc.ine.context.Context;

public class PlansService {

	public static void println(List<Context> contexts) {
		contexts.forEach(ctx -> {
			System.out.println("Context: " + ctx.getName() + ", type: " + ctx.getType());
			ctx.getClauses().forEach(System.out::println);
		});
	}

}
