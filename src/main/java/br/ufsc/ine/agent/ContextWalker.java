package br.ufsc.ine.agent;

import java.util.List;

import agent.AgentBaseListener;
import agent.AgentParser.ContextNameContext;
import br.ufsc.ine.context.Context;

public class ContextWalker extends AgentBaseListener {

	private List<Context> contexts;
	
	//TODO: mapear entrada do arquivo para a classe Context

	@Override
	public void enterContextName(ContextNameContext ctx) {
		System.out.println(ctx.getText());
		super.enterContextName(ctx);
	}

	public List<Context> getContexts() {
		return contexts;
	}

}
