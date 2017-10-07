package br.ufsc.ine.context.plans;

import java.util.List;

public class PlansContextService {

	public static PlansContextService instance;

	private PlansContextService() {

	}

	public static void startService() {
		instance = new PlansContextService();
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

}
