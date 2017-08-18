package br.ufsc.ine.antlr4.agent;

import java.util.ArrayList;
import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser.ContextNameContext;
import agent.AgentParser.FolClauseContext;

public class ContextWalker extends AgentBaseListener {

	private String contexName;
	private List<String> clauses = new ArrayList<>();

	@Override
	public void enterContextName(ContextNameContext ctx) {
		this.contexName = ctx.getText();
		super.enterContextName(ctx);
	}

	@Override
	public void enterFolClause(FolClauseContext ctx) {
		this.clauses.add(ctx.getText());
		super.enterFolClause(ctx);
	}

	public List<String> getClauses() {
		return clauses;
	}

	public String getContexName() {
		return contexName;
	}

}
