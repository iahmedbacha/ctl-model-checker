package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * EU model: E left U (right)
 */
public class EU extends Formula {
    /**
     * Left formula.
     */
    private final Formula left;

    /**
     * Right formula.
     */
    private final Formula right;

    /**
     * Construct EU model.
     *
     * @param left left formula.
     * @param right right formula.
     */
    public EU(Formula left, Formula right) {
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
     * Override toString of EU model.
     *
     * @return string representation of EU model.
     */
    @Override
    public String toString() {
        return "E " + left.toString() + " U ( " + right.toString() + " )";
    }

    /**
     * Call visitor of EU model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitEU(this);
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
        EU eu = (EU) o;
        return Objects.equals(left, eu.left) &&
                Objects.equals(right, eu.right);
    }

    /**
     * Override calculate hashCode of EU model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
