package formula.models;

import formula.visitors.FormulaVisitor;

public class Constant extends Formula {
    private boolean constant;

    public Constant(boolean constant) {
        this.constant = constant;
    }

    public boolean isConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant ? "true" : "false";
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitConstant(this);
    }
}
