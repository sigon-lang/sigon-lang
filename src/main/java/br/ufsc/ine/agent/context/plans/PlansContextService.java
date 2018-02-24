package br.ufsc.ine.agent.context.plans;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.communication.Actuator;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.List;

public class PlansContextService implements ContextService{

	private static PrologEnvironment prologEnvironment;
	public static PlansContextService instance = new PlansContextService();
	private List<Actuator> actuators;

	private PlansContextService() {
		prologEnvironment = new PrologEnvironment();
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

    public void executePlanAlgorithm() {
    }

	@Override
	public boolean verify(String fact) {
		SolveInfo solveGoal;
		try {
			solveGoal = prologEnvironment.solveGoal(fact);
			return solveGoal.isSuccess();
		} catch (MalformedGoalException e) {
			return false;
		}
	}

	@Override
	public void appendFact(String c) {
		try {
			prologEnvironment.appendFact(c);
		} catch (InvalidTheoryException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Theory getTheory(){
		return prologEnvironment.getEngine().getTheory();
	}

	@Override
	public String getName() {
		return "pc";
	}
}
