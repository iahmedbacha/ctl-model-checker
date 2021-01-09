package formula.visitors;

import formula.models.*;

public abstract class FormulaVisitor {
    public abstract void visitAnd(And and);
    public abstract void visitAU(AU au);
    public abstract void visitEU(EU eu);
    public abstract void visitEX(EX ex);
    public abstract void visitNegation(Negation negation);
    public abstract void visitProposition(Proposition proposition);
    public abstract void visitConstant(Constant constant);
}
