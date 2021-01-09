package formula.models;

import formula.visitors.FormulaVisitor;

public class EU extends Formula {
    private Formula left;
    private Formula right;

    public EU(Formula left, Formula right) {
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
        return "E " + left.toString() + " U ( " + right.toString() + " )";
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitEU(this);
    }
}
