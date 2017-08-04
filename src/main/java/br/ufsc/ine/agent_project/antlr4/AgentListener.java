// Generated from Agent.g4 by ANTLR 4.5
package br.ufsc.ine.agent_project;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AgentParser}.
 */
public interface AgentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AgentParser#agent}.
	 * @param ctx the parse tree
	 */
	void enterAgent(AgentParser.AgentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#agent}.
	 * @param ctx the parse tree
	 */
	void exitAgent(AgentParser.AgentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#contextDeclare}.
	 * @param ctx the parse tree
	 */
	void enterContextDeclare(AgentParser.ContextDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#contextDeclare}.
	 * @param ctx the parse tree
	 */
	void exitContextDeclare(AgentParser.ContextDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#primitiveContext}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveContext(AgentParser.PrimitiveContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#primitiveContext}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveContext(AgentParser.PrimitiveContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#customContext}.
	 * @param ctx the parse tree
	 */
	void enterCustomContext(AgentParser.CustomContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#customContext}.
	 * @param ctx the parse tree
	 */
	void exitCustomContext(AgentParser.CustomContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AgentParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AgentParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#plan}.
	 * @param ctx the parse tree
	 */
	void enterPlan(AgentParser.PlanContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#plan}.
	 * @param ctx the parse tree
	 */
	void exitPlan(AgentParser.PlanContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(AgentParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(AgentParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#somethingToBeTrue}.
	 * @param ctx the parse tree
	 */
	void enterSomethingToBeTrue(AgentParser.SomethingToBeTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#somethingToBeTrue}.
	 * @param ctx the parse tree
	 */
	void exitSomethingToBeTrue(AgentParser.SomethingToBeTrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#compoundaction}.
	 * @param ctx the parse tree
	 */
	void enterCompoundaction(AgentParser.CompoundactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#compoundaction}.
	 * @param ctx the parse tree
	 */
	void exitCompoundaction(AgentParser.CompoundactionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#preconditions}.
	 * @param ctx the parse tree
	 */
	void enterPreconditions(AgentParser.PreconditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#preconditions}.
	 * @param ctx the parse tree
	 */
	void exitPreconditions(AgentParser.PreconditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#postconditions}.
	 * @param ctx the parse tree
	 */
	void enterPostconditions(AgentParser.PostconditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#postconditions}.
	 * @param ctx the parse tree
	 */
	void exitPostconditions(AgentParser.PostconditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#formulas}.
	 * @param ctx the parse tree
	 */
	void enterFormulas(AgentParser.FormulasContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#formulas}.
	 * @param ctx the parse tree
	 */
	void exitFormulas(AgentParser.FormulasContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#bridgeRules}.
	 * @param ctx the parse tree
	 */
	void enterBridgeRules(AgentParser.BridgeRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#bridgeRules}.
	 * @param ctx the parse tree
	 */
	void exitBridgeRules(AgentParser.BridgeRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(AgentParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(AgentParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(AgentParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(AgentParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#propClause}.
	 * @param ctx the parse tree
	 */
	void enterPropClause(AgentParser.PropClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#propClause}.
	 * @param ctx the parse tree
	 */
	void exitPropClause(AgentParser.PropClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#folClause}.
	 * @param ctx the parse tree
	 */
	void enterFolClause(AgentParser.FolClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#folClause}.
	 * @param ctx the parse tree
	 */
	void exitFolClause(AgentParser.FolClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#propLogExpr}.
	 * @param ctx the parse tree
	 */
	void enterPropLogExpr(AgentParser.PropLogExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#propLogExpr}.
	 * @param ctx the parse tree
	 */
	void exitPropLogExpr(AgentParser.PropLogExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#folLogExpr}.
	 * @param ctx the parse tree
	 */
	void enterFolLogExpr(AgentParser.FolLogExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#folLogExpr}.
	 * @param ctx the parse tree
	 */
	void exitFolLogExpr(AgentParser.FolLogExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AgentParser#character}.
	 * @param ctx the parse tree
	 */
	void enterCharacter(AgentParser.CharacterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AgentParser#character}.
	 * @param ctx the parse tree
	 */
	void exitCharacter(AgentParser.CharacterContext ctx);
}