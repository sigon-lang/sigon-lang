package br.ufsc.ine.parser;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser.ActionPostconditionsContext;
import agent.AgentParser.ActionPreconditionsContext;
import agent.AgentParser.ArgumentListContext;
import agent.AgentParser.FunctionNameContext;
import agent.AgentParser.PlanPostconditionsContext;
import agent.AgentParser.PlanPreconditionsContext;
import agent.AgentParser.PlanTypeContext;
import agent.AgentParser.PlansFormulasContext;
import agent.AgentParser.SomethingToBeTrueContext;
import br.ufsc.ine.context.plans.Action;
import br.ufsc.ine.context.plans.Plan;

public class PlanWalker extends AgentBaseListener {

	private List<Plan> plans = new ArrayList<>();
	private Plan plan;
	private Action action;

	@Override
	public void enterPlanType(PlanTypeContext ctx) {
		this.plan = new Plan();
		this.plan.setType(ctx.getText());
		super.enterPlanType(ctx);
	}

	@Override
	public void enterSomethingToBeTrue(SomethingToBeTrueContext ctx) {
		this.plan.setSomethingToBeTrue(ctx.getText());
		super.enterSomethingToBeTrue(ctx);
	}

	@Override
	public void enterPlanPreconditions(PlanPreconditionsContext ctx) {
		this.plan.getPreConditions().add(ctx.getText());
		super.enterPlanPreconditions(ctx);
	}

	@Override
	public void enterPlanPostconditions(PlanPostconditionsContext ctx) {
		this.plan.getPosConditions().add(ctx.getText());
		super.enterPlanPostconditions(ctx);
	}

	@Override
	public void enterFunctionName(FunctionNameContext ctx) {
		this.action = new Action();
		this.action.setName(ctx.getText());
		super.enterFunctionName(ctx);
	}

	@Override
	public void enterArgumentList(ArgumentListContext ctx) {
		this.action.getArguments().add(ctx.getText());
		super.enterArgumentList(ctx);
	}

	@Override
	public void enterActionPreconditions(ActionPreconditionsContext ctx) {
		action.getPreConditions().add(ctx.getText());
		super.enterActionPreconditions(ctx);
	}

	@Override
	public void enterActionPostconditions(ActionPostconditionsContext ctx) {
		action.getPosConditions().add(ctx.getText());
		this.plan.getActions().add(action);
		super.enterActionPostconditions(ctx);
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
