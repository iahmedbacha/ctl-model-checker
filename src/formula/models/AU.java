package formula.models;

import formula.visitors.FormulaVisitor;

public class AU extends Formula {
    private Formula left;
    private Formula right;

    public AU(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "A " + left.toString() + " U ( " + right.toString() + " )";
    }

    @Override
    void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAU(this);
    }
}