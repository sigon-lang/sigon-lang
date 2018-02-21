package br.ufsc.ine.parser;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser;
import agent.AgentParser.ContextNameContext;
import agent.AgentParser.FolFormulaContext;
import agent.AgentParser.FormulasContext;
import agent.AgentParser.PropFormulaContext;
import br.ufsc.ine.actuator.LangActuator;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.plans.Action;
import br.ufsc.ine.context.plans.Plan;
import br.ufsc.ine.sensor.LangSensor;

public class AgentWalker extends AgentBaseListener {

	private List<Plan> plans = new ArrayList<>();
	private Plan plan;
	private Action action;

	private List<Context> contexts = new ArrayList<>();

	private List<LangSensor> langSensors = new ArrayList<>();
	private List<LangActuator> langActuators = new ArrayList<>();

	private Context lastContext;
	private LangSensor lastSensor;
	private LangActuator lastActuator;

	@Override
	public void enterActuator(AgentParser.ActuatorContext ctx) {
		this.lastActuator = new LangActuator();
		super.enterActuator(ctx);
	}

	@Override
	public void enterActuatorIdentifier(AgentParser.ActuatorIdentifierContext ctx) {
		this.lastActuator.setIdentifier(ctx.getText().replace("\"", ""));
		super.enterActuatorIdentifier(ctx);
	}

	@Override
	public void enterActuatorImplementation(AgentParser.ActuatorImplementationContext ctx) {
		this.lastActuator.setImplementation(ctx.getText().replace("\"", ""));
		this.langActuators.add(this.lastActuator);
		super.enterActuatorImplementation(ctx);
	}

	@Override
	public void enterSensor(AgentParser.SensorContext ctx) {
		this.lastSensor = new LangSensor();
		super.enterSensor(ctx);
	}

	@Override
	public void enterSensorIdentifier(AgentParser.SensorIdentifierContext ctx) {
		this.lastSensor.setIdentifier(ctx.getText().replace("\"", ""));
		super.enterSensorIdentifier(ctx);
	}

	@Override
	public void enterSensorImplementation(AgentParser.SensorImplementationContext ctx) {
		this.lastSensor.setImplementation(ctx.getText().replace("\"", ""));
		this.getLangSensors().add(this.lastSensor);
		super.enterSensorImplementation(ctx);
	}

	@Override
	public void enterContextName(ContextNameContext ctx) {
		this.lastContext = new Context();
		this.lastContext.setName(ctx.getText());
		super.enterContextName(ctx);
	}



	@Override
	public void enterPropFormula(PropFormulaContext ctx) {
		this.lastContext.addClause(ctx.getText());
		super.enterPropFormula(ctx);
	}

	@Override
	public void enterFolFormula(FolFormulaContext ctx) {
		this.lastContext.addClause(ctx.getText());
		super.enterFolFormula(ctx);
	}

	@Override
	public void enterFormulas(FormulasContext ctx) {
		this.contexts.add(lastContext);
		super.enterFormulas(ctx);
	}


	@Override
	public void enterSomethingToBeTrue(AgentParser.SomethingToBeTrueContext ctx) {
		this.plan = new Plan();
		this.getPlans().add(plan);
	    this.plan.setSomethingToBeTrue(ctx.getText());
		super.enterSomethingToBeTrue(ctx);
	}

	@Override
	public void enterPlanPreconditions(AgentParser.PlanPreconditionsContext ctx) {
		this.plan.getPreConditions().add(ctx.getText());
		super.enterPlanPreconditions(ctx);
	}

	@Override
	public void enterPlanPostconditions(AgentParser.PlanPostconditionsContext ctx) {
		this.plan.getPosConditions().add(ctx.getText());
		super.enterPlanPostconditions(ctx);
	}

	@Override
	public void enterFunctionName(AgentParser.FunctionNameContext ctx) {
		this.action = new Action();
		this.action.setName(ctx.getText());
		super.enterFunctionName(ctx);
	}

	@Override
	public void enterArgumentList(AgentParser.ArgumentListContext ctx) {
		this.action.getArguments().add(ctx.getText());
		super.enterArgumentList(ctx);
	}

	@Override
	public void enterActionPreconditions(AgentParser.ActionPreconditionsContext ctx) {
		action.getPreConditions().add(ctx.getText());
		super.enterActionPreconditions(ctx);
	}

	@Override
	public void enterActionPostconditions(AgentParser.ActionPostconditionsContext ctx) {
		action.getPosConditions().add(ctx.getText());
		this.plan.getActions().add(action);
		super.enterActionPostconditions(ctx);
	}



	public List<Context> getContexts() {
		return contexts;
	}

	public List<LangSensor> getLangSensors() {
		return langSensors;
	}

	public List<LangActuator> getLangActuators() {
		return langActuators;
	}

	public List<Plan> getPlans() {
		return plans;
	}
}
