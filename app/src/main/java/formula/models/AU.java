package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * AU model: A left U (right)
 */
public class AU extends Formula {
    /**
     * Left formula.
     */
    private final Formula left;
    /**
     * Right formula.
     */
    private final Formula right;

    /**
     * Construct AU model.
     *
     * @param left left formula.
     * @param right right formula.
     */
    public AU(Formula left, Formula right) {
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
     * Override toString of AU model.
     *
     * @return string representation of AU model.
     */
    @Override
    public String toString() {
        return "A " + left.toString() + " U ( " + right.toString() + " )";
    }

    /**
     * Call visitor of AU model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitAU(this);
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
        AU au = (AU) o;
        return Objects.equals(left, au.left) &&
                Objects.equals(right, au.right);
    }

    /**
     * Calculate hashCode of AU model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
