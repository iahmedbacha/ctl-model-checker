package formula.visitors;

import antlr.CTLBaseVisitor;
import antlr.CTLParser;
import formula.models.*;

/**
 * CTL concrete visitor: transform an ANTLR AST to formula object
 */
public class CTLConcreteVisitor extends CTLBaseVisitor<Formula> {
    /**
     * {@inheritDoc}
     *
     * Override visit EU node
     * The concrete implementation returns EU object
     */
    @Override
    public Formula visitEU(CTLParser.EUContext ctx) {
        Formula left = visit(ctx.getChild(1));
        Formula right = visit(ctx.getChild(4));
        return new EU(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit EX node
     * The concrete implementation returns EX object
     */
    @Override
    public Formula visitEX(CTLParser.EXContext ctx) {
        Formula formula = visit(ctx.getChild(2));
        return new EX(formula);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Negation node
     * The concrete implementation returns Negation object
     */
    @Override
    public Formula visitNegation(CTLParser.NegationContext ctx) {
        Formula formula = visit(ctx.getChild(2));
        return new Negation(formula);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit AU node
     * The concrete implementation returns AU object
     */
    @Override
    public Formula visitAU(CTLParser.AUContext ctx) {
        Formula left = visit(ctx.getChild(1));
        Formula right = visit(ctx.getChild(4));
        return new AU(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit And node
     * The concrete implementation returns And object
     */
    @Override
    public Formula visitAnd(CTLParser.AndContext ctx) {
        Formula left = visit(ctx.getChild(0));
        Formula right = visit(ctx.getChild(2));
        return new And(left, right);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Constant node
     * The concrete implementation returns Constant object
     */
    @Override
    public Formula visitConstant(CTLParser.ConstantContext ctx) {
        boolean constant = ctx.getChild(0).getText().equals("T");
        return new Constant(constant);
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Proposition node
     * The concrete implementation returns Proposition object
     */
    @Override
    public Formula visitProposition(CTLParser.PropositionContext ctx) {
        String designation = ctx.getChild(0).getText();
        return new Proposition(designation);
    }
}
