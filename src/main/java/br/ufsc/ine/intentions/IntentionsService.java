package br.ufsc.ine.intentions;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.Context;

public class IntentionsService {

	private static final String DESIRES = "desires";
	private static final Object BELIEFS = "beliefs";

	public static void intentions(List<Context> contexts) {

		List<String> desires = contexts.stream().filter(c -> c.getName().equals(DESIRES)).map(c -> c.getClauses())
				.flatMap(Collection::stream).collect(Collectors.toList());

		List<String> beliefs = contexts.stream().filter(c -> c.getName().equals(BELIEFS)).map(c -> c.getClauses())
				.flatMap(Collection::stream).collect(Collectors.toList());

		List<String> collect = beliefs.stream().filter(desires::contains).collect(Collectors.toList());

		System.out.println(collect);

	}

}
