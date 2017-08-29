package br.ufsc.ine.context.plans;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.desires.DesiresService;

public class PlansService {

	public static void run(List<Plan> plans) {
		plans.forEach(p -> {
			List<String> collect = p.getPosConditions().stream().filter(c -> DesiresService.instance.haveDesire(c))
					.collect(Collectors.toList());

			if (collect.size() == p.getPosConditions().size()) {
				p.getFunctions().forEach(f -> {
					System.out.println("Executar função: " + f.getName());
					System.out.println();
					System.out.println("Argumentos: ");

					f.getArguments().forEach(System.out::println);

				});
			}
		});
	}

}
