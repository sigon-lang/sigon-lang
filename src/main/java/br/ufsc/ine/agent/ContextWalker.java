package br.ufsc.ine.agent;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser.ContextNameContext;
import agent.AgentParser.FolFormulaContext;
import agent.AgentParser.FormulasContext;
import agent.AgentParser.PropFormulaContext;
import agent.AgentParser.TypeContext;
import br.ufsc.ine.context.Context;

public class ContextWalker extends AgentBaseListener {

	private List<Context> contexts = new ArrayList<>();

	private Context lastContext;

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

}
