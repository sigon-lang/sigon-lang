package br.ufsc.ine.context.plans;

import br.ufsc.ine.actuator.Actuator;

import java.util.List;

public class PlansContextService {

	public static PlansContextService instance;
	private List<Actuator> actuators;

	private PlansContextService() {

	}

	public static void startService(List<Actuator> actuators) {
		instance = new PlansContextService();
		instance.actuators = actuators;
	}

	public static PlansContextService getInstance() {
		return instance;
	}
	
	private List<Plan> plans;

	public void plans(List<Plan> plans) {
		this.plans = plans;
		
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public List<Actuator> getActuators() {
		return actuators;
	}
}
