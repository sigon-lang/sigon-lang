package br.ufsc.ine.parser;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser;
import agent.AgentParser.ContextNameContext;
import agent.AgentParser.FolFormulaContext;
import agent.AgentParser.FormulasContext;
import agent.AgentParser.PropFormulaContext;
import agent.AgentParser.TypeContext;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.sensor.LangSensor;

public class AgentWalker extends AgentBaseListener {

	private List<Context> contexts = new ArrayList<>();
	private List<LangSensor> langSensors = new ArrayList<>();

	private Context lastContext;
	private LangSensor lastSensor;

	@Override
	public void enterSensor(AgentParser.SensorContext ctx) {
		this.lastSensor = new LangSensor();
		super.enterSensor(ctx);
	}

	@Override
	public void enterSensorName(AgentParser.SensorNameContext ctx) {
		this.lastSensor.setName(ctx.getText());
		super.enterSensorName(ctx);
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
	public void enterType(TypeContext ctx) {
		this.lastContext.setType(ctx.getText());
		super.enterType(ctx);
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

	public List<Context> getContexts() {
		return contexts;
	}

	public List<LangSensor> getLangSensors() {
		return langSensors;
	}
}
