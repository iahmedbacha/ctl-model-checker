// Generated from /Users/iahmedbacha/Desktop/ctl-model-checker/CTL.g4 by ANTLR 4.9
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code EU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEU(CTLParser.EUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EX}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEX(CTLParser.EXContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(CTLParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AU}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAU(CTLParser.AUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CTLParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CTLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Proposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProposition(CTLParser.PropositionContext ctx);
}