package br.ufsc.ine.antlr4.agent;

import agent.AgentBaseListener;
import agent.AgentParser.ActionContext;
import agent.AgentParser.BridgeRuleContext;
import agent.AgentParser.PrimitiveContextNameContext;
import agent.AgentParser.TypeContext;

public class AgentWalker extends AgentBaseListener {

	@Override
	public void enterAction(ActionContext ctx) {
		System.out.println(ctx.getText());
		super.enterAction(ctx);
	}

	@Override
	public void enterPrimitiveContextName(PrimitiveContextNameContext ctx) {
		System.out.println(ctx.getText());
		super.enterPrimitiveContextName(ctx);
	}
	
	@Override
	public void enterType(TypeContext ctx) {
		System.out.println(ctx.getText());
		super.enterType(ctx);
	}
	
	@Override
	public void enterBridgeRule(BridgeRuleContext ctx) {
		System.out.println(ctx.getText());
		super.enterBridgeRule(ctx);
	}
}
