package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * And model: left &amp; right
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
     * Override call visitor of And model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAnd(this);
    }

    /**
     * Override compare with another object.
     *
     * @param o object to compare with
     * @return equals boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        And and = (And) o;
        return Objects.equals(left, and.left) &&
                Objects.equals(right, and.right);
    }

    /**
     * Override calculate hashCode of And model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
