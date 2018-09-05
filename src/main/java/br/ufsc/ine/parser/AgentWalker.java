package br.ufsc.ine.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser;
import agent.AgentParser.LogicalContextNameContext;
import agent.AgentParser.ContextContext;
import agent.AgentParser.FormulasContext;
import agent.AgentParser.HeadContext;
import agent.AgentParser.LogicalContextContext;
import br.ufsc.ine.agent.context.communication.LangActuator;
import br.ufsc.ine.agent.context.LangContext;
import br.ufsc.ine.agent.context.plans.Action;
import br.ufsc.ine.agent.context.plans.Plan;
import br.ufsc.ine.agent.context.communication.LangSensor;

public class AgentWalker extends AgentBaseListener {

	private List<Plan> plans = new ArrayList<>();
	private Plan plan;
	private Action action;

	//TODO: usar objetos criados pelo ant e remover classes LangContext, LangSensor, LangActuator
	private List<LangContext> langContexts = new ArrayList<>();
	private List<LangSensor> langSensors = new ArrayList<>();
	private List<LangActuator> langActuators = new ArrayList<>();


	private List<AgentParser.BridgeRuleContext> bridgeRules  = new ArrayList<>();

	
	private LangContext lastLangContext;
	private LangSensor lastSensor;
	private LangActuator lastActuator;

	private List<String> plansClauses = new ArrayList<>();

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
	public void enterHead(HeadContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("Head1 "+ctx.contextName().getText());
		System.out.println("Terms head1 "+ctx.term().getText());
		super.enterHead(ctx);
	}
	
	
	 



	/*@Override
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
			this.lastLangContext.addClause(builder.toString());
		}
		this.lastLangContext.addClause(ctx.getText());
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
			this.lastLangContext.addClause(builder.toString());
		} else{
			this.lastLangContext.addClause(ctx.getText());
		}
		super.enterFolFormula(ctx);
	}*/

	@Override
	public void enterLogicalContext(LogicalContextContext ctx) {
		this.lastLangContext = new LangContext();
		this.lastLangContext.setName(ctx.logicalContextName().getText());
		if(ctx.formulas()!=null && ctx.formulas().term()!=null) { 
			ctx.formulas().term().forEach(t->{
				 this.lastLangContext.addClause(t.getText());
			 });
		}
		super.enterLogicalContext(ctx);
		this.langContexts.add(lastLangContext);
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
		ctx.conditions().term().term().forEach(c -> {
			this.plan.getPreConditions().add(c.getText());
		});
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
		this.plan.getActions().add(action);
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
		this.action.getPosConditions().add(ctx.getText());
		super.enterActionPostconditions(ctx);
	}


	@Override
	public void enterPlan(AgentParser.PlanContext ctx) {
		StringBuilder builder = new StringBuilder();
		builder.append("plan(");
		builder.append(ctx.somethingToBeTrue().getText());
		builder.append(",_");
		builder.append(",[");
		StringBuilder list = new StringBuilder();

		if(ctx.planPreconditions()!=null) {
			 ctx.planPreconditions().conditions().term().term()
					.forEach(e -> {
						String clause = null;
						if (e.getText().contains("(") && e.getText().contains(")")) {
							StringBuilder builderPre = new StringBuilder();
							String c = e.getText();
							String toReplace = c.substring(c.indexOf("(") + 1, c.lastIndexOf(")"));
							Arrays.stream(toReplace.split(",")).map(i -> "_,").forEach(builderPre::append);
							StringBuilder test = new StringBuilder();
							test.append(c.substring(0, c.indexOf("(")));
							test.append("(");
							test.append(builderPre.toString().substring(0, builderPre.toString().length() - 1));
							test.append(")");
							clause =  test + ",";
						} else {
							clause = e.getText() + ",";
						}

						if(clause.length()>=3) {
							if (clause.substring(0,3).equals("not")) {
								list.append("\\+"+clause.substring(3));
								list.append(clause.replaceAll("not", ""));
							}

							if (!clause.substring(0,3).equals("not")) {
								list.append(clause);
								list.append("\\+" + clause);
							}
						} else {
							list.append(clause);
						}



					});
			if(list!=null && list.length()!=0)
				builder.append(list.toString().substring(0, list.toString().length() - 1));
		} else{
			builder.append("_");
		}

		builder.append("],_).");
		plansClauses.add(builder.toString());
		super.enterPlan(ctx);
	}

	@Override
	public void enterBridgeRule(AgentParser.BridgeRuleContext ctx) {
		this.bridgeRules.add(ctx);
		super.enterBridgeRule(ctx);
	}

	public List<AgentParser.BridgeRuleContext> getBridgeRules() {
		
		for (AgentParser.BridgeRuleContext ctx : bridgeRules) {
			System.out.println("Head: "+ctx.head().contextName().getText());
			System.out.println("Body: "+ctx.body().contextName(0).getText());
			System.out.println("Body term : "+ctx.body().term(0).getText());
			
		}
		return bridgeRules;
	}

	public List<String> getPlansClauses() {
		return plansClauses;
	}

	public List<LangContext> getLangContexts() {
		return langContexts;
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
