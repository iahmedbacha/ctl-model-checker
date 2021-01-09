package formula.models;

import formula.visitors.FormulaVisitor;

public class And extends Formula {
    private Formula left;
    private Formula right;

    public And(Formula left, Formula right) {
        this.left = left;
        this.right = right;
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
