package formula.visitors;

import antlr.CTLBaseVisitor;
import antlr.CTLParser;

public class CTLTranspilerConcreteVisitor extends CTLBaseVisitor<String> {
    @Override
    public String visitTrue(CTLParser.TrueContext ctx) {
        return "+";
    }

    @Override
    public String visitFalse(CTLParser.FalseContext ctx) {
        return "(!+)";
    }

    @Override
    public String visitProposition(CTLParser.PropositionContext ctx) {
        return ctx.getChild(0).getText();
    }

    @Override
    public String visitNegation(CTLParser.NegationContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!"+formula+")";
    }

    @Override
    public String visitAnd(CTLParser.AndContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "("+left+"&"+right+")";
    }

    @Override
    public String visitOr(CTLParser.OrContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "(!("+left+"&"+right+"))";
    }

    @Override
    public String visitImplication(CTLParser.ImplicationContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "(!(!"+left+")&("+right+"))";
    }

    @Override
    public String visitEquivalence(CTLParser.EquivalenceContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "((!(!"+left+")&("+right+"))&(!(!"+right+")&("+left+")))";
    }

    @Override
    public String visitAX(CTLParser.AXContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!EX(!"+formula+"))";
    }

    @Override
    public String visitEX(CTLParser.EXContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "EX"+formula;
    }

    @Override
    public String visitAF(CTLParser.AFContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "A[+U"+formula+"]";
    }

    @Override
    public String visitEF(CTLParser.EFContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "E[+U"+formula+"]";
    }

    @Override
    public String visitAG(CTLParser.AGContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!E[+U(!"+formula+")])";
    }

    @Override
    public String visitEG(CTLParser.EGContext ctx) {
        String formula = visit(ctx.getChild(1));
        return "(!A[+U(!"+formula+")])";
    }

    @Override
    public String visitAU(CTLParser.AUContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "A["+left+"U"+right+"]";
    }

    @Override
    public String visitEU(CTLParser.EUContext ctx) {
        String left = visit(ctx.getChild(1));
        String right = visit(ctx.getChild(3));
        return "E["+left+"U"+right+"]";
    }
}
