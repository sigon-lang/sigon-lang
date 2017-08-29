package br.ufsc.ine.agent;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser.ArgumentListContext;
import agent.AgentParser.FunctionNameContext;
import agent.AgentParser.PlanTypeContext;
import agent.AgentParser.PlansFormulasContext;
import agent.AgentParser.PostconditionsContext;
import agent.AgentParser.PreconditionsContext;
import br.ufsc.ine.context.plans.Function;
import br.ufsc.ine.context.plans.Plan;

public class PlanWalker extends AgentBaseListener{
	
	private List<Plan> plans = new ArrayList<>();
	private Plan plan;
	private Function function;
	
	 
	
	 
	 
	@Override
	public void enterPlanType(PlanTypeContext ctx) {
		this.plan = new Plan();
		this.plan.setType(ctx.getText());
		super.enterPlanType(ctx);
	}
	 
	@Override
	public void enterPreconditions(PreconditionsContext ctx) {
		this.plan.getPreConditions().add(ctx.getText());
		super.enterPreconditions(ctx);
	}
	
	@Override
	public void enterPostconditions(PostconditionsContext ctx) {
		this.plan.getPosConditions().add(ctx.getText());
		super.enterPostconditions(ctx);
	}
	
	@Override
	public void enterFunctionName(FunctionNameContext ctx) {
		this.function = new Function();
		this.function.setName(ctx.getText());
		super.enterFunctionName(ctx);
	}
	
	@Override
	public void enterArgumentList(ArgumentListContext ctx) {
		this.function.getArguments().add(ctx.getText());
		this.plan.getFunctions().add(this.function);
		super.enterArgumentList(ctx);
	}
	
	@Override
	public void enterPlansFormulas(PlansFormulasContext ctx) {
		this.getPlans().add(plan);
		super.enterPlansFormulas(ctx);
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

}
