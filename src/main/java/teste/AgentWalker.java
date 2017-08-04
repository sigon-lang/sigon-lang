package teste;

import agent.AgentBaseListener;
import agent.AgentParser.ActionContext;
import agent.AgentParser.BridgeRulesContext;
import agent.AgentParser.PrimitiveContextContext;
import agent.AgentParser.TypeContext;

public class AgentWalker extends AgentBaseListener {

	@Override
	public void enterAction(ActionContext ctx) {
		System.out.println(ctx.getText());
		super.enterAction(ctx);
	}

	@Override
	public void enterPrimitiveContext(PrimitiveContextContext ctx) {
		System.out.println(ctx.getText());
		super.enterPrimitiveContext(ctx);
	}
	
	@Override
	public void enterType(TypeContext ctx) {
		System.out.println(ctx.getText());
		super.enterType(ctx);
	}
	
	@Override
	public void enterBridgeRules(BridgeRulesContext ctx) {
		System.out.println(ctx.getText());
		super.enterBridgeRules(ctx);
	}
}
