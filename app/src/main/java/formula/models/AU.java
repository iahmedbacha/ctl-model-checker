package formula.models;

import formula.visitors.FormulaVisitor;

public class AU extends Formula {
    private final Formula left;
    private final Formula right;

    public AU(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    public Formula getLeft() {
        return left;
    }

    public Formula getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "A " + left.toString() + " U ( " + right.toString() + " )";
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAU(this);
    }
}
