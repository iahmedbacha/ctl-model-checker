package formula.models;

import formula.visitors.FormulaVisitor;

public class And extends Formula {
    private Formula left;
    private Formula right;

    public And(Formula left, Formula right) {
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
        return left.toString() + " & " + right.toString();
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAnd(this);
    }
}
