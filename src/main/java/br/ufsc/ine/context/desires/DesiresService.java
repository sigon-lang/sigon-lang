package br.ufsc.ine.context.desires;

import java.util.List;

import br.ufsc.ine.context.Context;

public class DesiresService {

	public static void println(List<Context> contexts) {
		contexts.forEach(ctx -> {
			System.out.println("Context: " + ctx.getName() + ", type: " + ctx.getType());
			ctx.getClauses().forEach(System.out::println);
		});
	}

}
