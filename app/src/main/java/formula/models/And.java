package formula.models;

import formula.visitors.FormulaVisitor;

/**
 * And model (left & right)
 */
public class And extends Formula {
    /**
     * Left formula.
     */
    private final Formula left;
    /**
     * Right formula.
     */
    private final Formula right;

    /**
     * Construct And model.
     *
     * @param left left formula.
     * @param right right formula.
     */
    public And(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Get left formula.
     *
     * @return left formula.
     */
    public Formula getLeft() {
        return left;
    }

    /**
     * Get right formula.
     *
     * @return right formula.
     */
    public Formula getRight() {
        return right;
    }

    /**
     * Override toString of And model.
     *
     * @return string representation of And model.
     */
    @Override
    public String toString() {
        return left.toString() + " & " + right.toString();
    }

    /**
     * Call visitor of And model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAnd(this);
    }
}
