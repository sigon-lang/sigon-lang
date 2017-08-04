// Generated from Agent.g4 by ANTLR 4.5
package br.ufsc.ine.agent_project;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AgentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AgentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AgentParser#agent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent(AgentParser.AgentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#contextDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextDeclare(AgentParser.ContextDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#primitiveContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveContext(AgentParser.PrimitiveContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#customContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomContext(AgentParser.CustomContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AgentParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#plan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlan(AgentParser.PlanContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(AgentParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#somethingToBeTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomethingToBeTrue(AgentParser.SomethingToBeTrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#compoundaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundaction(AgentParser.CompoundactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#preconditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreconditions(AgentParser.PreconditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#postconditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostconditions(AgentParser.PostconditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#formulas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulas(AgentParser.FormulasContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#bridgeRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBridgeRules(AgentParser.BridgeRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(AgentParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(AgentParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#propClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropClause(AgentParser.PropClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#folClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolClause(AgentParser.FolClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#propLogExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropLogExpr(AgentParser.PropLogExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#folLogExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolLogExpr(AgentParser.FolLogExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AgentParser#character}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacter(AgentParser.CharacterContext ctx);
}