package formula.visitors;

import antlr.CTLBaseVisitor;
import antlr.CTLParser;

/**
 * CTLTranspilerConcreteVisitor transpile a ctl formula to a minimal set of operators
 */
public class CTLTranspilerConcreteVisitor extends CTLBaseVisitor<String> {
    /**
     * {@inheritDoc}
     *
     * Override visit True node
     * The concrete implementation returns True representation
     */
    @Override
    public String visitTrue(CTLParser.TrueContext ctx) {
        return "+";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit False node
     * The concrete implementation returns False transpilation
     */
    @Override
    public String visitFalse(CTLParser.FalseContext ctx) {
        return "(!+)";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Proposition node
     * The concrete implementation returns Proposition representation
     */
    @Override
    public String visitProposition(CTLParser.PropositionContext ctx) {
        return ctx.getChild(0).getText();
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Negation node
     * The concrete implementation returns Negation representation
     */
    @Override
    public String visitNegation(CTLParser.NegationContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!"+formula+")";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit And node
     * The concrete implementation returns And representation
     */
    @Override
    public String visitAnd(CTLParser.AndContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "("+left+"&"+right+")";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Or node
     * The concrete implementation returns Or transpilation
     */
    @Override
    public String visitOr(CTLParser.OrContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "(!("+left+"&"+right+"))";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Implication node
     * The concrete implementation returns Implication transpilation
     */
    @Override
    public String visitImplication(CTLParser.ImplicationContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "(!(!"+left+")&("+right+"))";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit Equivalence node
     * The concrete implementation returns Equivalence transpilation
     */
    @Override
    public String visitEquivalence(CTLParser.EquivalenceContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "((!(!"+left+")&("+right+"))&(!(!"+right+")&("+left+")))";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit AX node
     * The concrete implementation returns AX transpilation
     */
    @Override
    public String visitAX(CTLParser.AXContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!EX(!"+formula+"))";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit EX node
     * The concrete implementation returns EX representation
     */
    @Override
    public String visitEX(CTLParser.EXContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "EX"+formula;
    }

    /**
     * {@inheritDoc}
     *
     * Override visit AF node
     * The concrete implementation returns AF transpilation
     */
    @Override
    public String visitAF(CTLParser.AFContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "A[+U"+formula+"]";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit EF node
     * The concrete implementation returns EF transpilation
     */
    @Override
    public String visitEF(CTLParser.EFContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "E[+U"+formula+"]";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit AG node
     * The concrete implementation returns AG transpilation
     */
    @Override
    public String visitAG(CTLParser.AGContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!E[+U(!"+formula+")])";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit EG node
     * The concrete implementation returns EG transpilation
     */
    @Override
    public String visitEG(CTLParser.EGContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!A[+U(!"+formula+")])";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit AU node
     * The concrete implementation returns AU representation
     */
    @Override
    public String visitAU(CTLParser.AUContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "A["+left+"U"+right+"]";
    }

    /**
     * {@inheritDoc}
     *
     * Override visit EU node
     * The concrete implementation returns EU representation
     */
    @Override
    public String visitEU(CTLParser.EUContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "E["+left+"U"+right+"]";
    }
}
