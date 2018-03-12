package br.ufsc.ine.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import agent.AgentBaseListener;
import agent.AgentParser;
import agent.AgentParser.LogicalContextNameContext;
import agent.AgentParser.FolFormulaContext;
import agent.AgentParser.FormulasContext;
import agent.AgentParser.PropFormulaContext;
import br.ufsc.ine.agent.context.communication.LangActuator;
import br.ufsc.ine.agent.context.Context;
import br.ufsc.ine.agent.context.plans.Action;
import br.ufsc.ine.agent.context.plans.Plan;
import br.ufsc.ine.agent.context.communication.LangSensor;

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
		this.lastActuator.setIdentifier(ctx.getText().replaceAll("\"", ""));
		super.enterActuatorIdentifier(ctx);
	}

	@Override
	public void enterActuatorImplementation(AgentParser.ActuatorImplementationContext ctx) {
		this.lastActuator.setImplementation(ctx.getText().replaceAll("\"", ""));
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
		this.lastSensor.setIdentifier(ctx.getText().replaceAll("\"", ""));
		super.enterSensorIdentifier(ctx);
	}

	@Override
	public void enterSensorImplementation(AgentParser.SensorImplementationContext ctx) {
		this.lastSensor.setImplementation(ctx.getText().replaceAll("\"", ""));
		this.getLangSensors().add(this.lastSensor);
		super.enterSensorImplementation(ctx);
	}

	@Override
	public void enterLogicalContextName(LogicalContextNameContext ctx) {
		this.lastContext = new Context();
		this.lastContext.setName(ctx.getText());
		super.enterLogicalContextName(ctx);
	}



	@Override
	public void enterPropFormula(PropFormulaContext ctx) {
		AgentParser.AnnotationContext annotationContext = ctx.propClause().annotation();
		if(annotationContext!=null && annotationContext.gradedValue()!=null){
			String gradedValue = annotationContext.gradedValue().getText().replaceAll("->", "");
			String clause = ctx.propClause().constant().getText();
			StringBuilder builder = new StringBuilder();
			builder.append(clause);
			builder.append("(");
			builder.append(gradedValue);
			builder.append(").");
			this.lastContext.addClause(builder.toString());
		}
		this.lastContext.addClause(ctx.getText());
		super.enterPropFormula(ctx);
	}

	@Override
	public void enterFolFormula(FolFormulaContext ctx) {
		AgentParser.AnnotationContext annotationContext = ctx.folClause().annotation();
		if(annotationContext!=null && annotationContext.gradedValue()!=null){
			String gradedValue = annotationContext.gradedValue().getText().replaceAll("->", "");
			String clause = ctx.getText();
			StringBuilder builder = new StringBuilder();
			builder.append(clause.substring(0, clause.lastIndexOf(")")));
			builder.append(",");
			builder.append(gradedValue);
			builder.append(").");
			this.lastContext.addClause(builder.toString());
		} else{
			this.lastContext.addClause(ctx.getText());
		}
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
