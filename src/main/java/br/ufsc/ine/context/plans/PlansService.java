package br.ufsc.ine.context.plans;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.ine.context.desires.DesiresContextService;
import br.ufsc.ine.environment.Environment;

public class PlansService {
	
 
	public static void execute(List<Plan> plans) {
//		plans.forEach(p -> {
//			List<String> collect = p.getPosConditions().stream().filter(c -> DesiresContext.instance.haveDesire(c))
//					.collect(Collectors.toList());
//
//			if (collect.size() == p.getPosConditions().size()) {
//				p.getFunctions().forEach(Environment.getInstance()::execute);
//			}
//		});
	}

}
