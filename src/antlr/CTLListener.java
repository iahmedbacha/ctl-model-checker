// Generated from /Users/iahmedbacha/Desktop/ctl-model-checker/CTL.g4 by ANTLR 4.9
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CTLParser}.
 */
public interface CTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code EU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEU(CTLParser.EUContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEU(CTLParser.EUContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EX}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEX(CTLParser.EXContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EX}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEX(CTLParser.EXContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CTLParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CTLParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAU(CTLParser.AUContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAU(CTLParser.AUContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CTLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CTLParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(CTLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(CTLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Proposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterProposition(CTLParser.PropositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Proposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitProposition(CTLParser.PropositionContext ctx);
}