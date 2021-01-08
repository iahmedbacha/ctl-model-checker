package visitors;

import antlr.CTLBaseVisitor;
import antlr.CTLParser;
import formula.*;

public class AntlrToFormula extends CTLBaseVisitor<Formula> {
    @Override
    public Formula visitEU(CTLParser.EUContext ctx) {
        Formula left = visit(ctx.getChild(1));
        Formula right = visit(ctx.getChild(4));
        return new EU(left, right);
    }

    @Override
    public Formula visitEX(CTLParser.EXContext ctx) {
        Formula formula = visit(ctx.getChild(2));
        return new EX(formula);
    }

    @Override
    public Formula visitNegation(CTLParser.NegationContext ctx) {
        Formula formula = visit(ctx.getChild(2));
        return new Negation(formula);
    }

    @Override
    public Formula visitAU(CTLParser.AUContext ctx) {
        Formula left = visit(ctx.getChild(1));
        Formula right = visit(ctx.getChild(4));
        return new AU(left, right);
    }

    @Override
    public Formula visitAnd(CTLParser.AndContext ctx) {
        Formula left = visit(ctx.getChild(0));
        Formula right = visit(ctx.getChild(2));
        return new And(left, right);
    }

    @Override
    public Formula visitConstant(CTLParser.ConstantContext ctx) {
        boolean constant = ctx.getChild(0).getText().equals("T");
        return new Constant(constant);
    }

    @Override
    public Formula visitProposition(CTLParser.PropositionContext ctx) {
        String designation = ctx.getChild(0).getText();
        return new Proposition(designation);
    }
}
