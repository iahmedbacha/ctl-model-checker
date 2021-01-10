package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * Constant model: constant
 */
public class Constant extends Formula {
    /**
     * Constant boolean.
     */
    private final boolean constant;

    /**
     * Construct Constant model.
     *
     * @param constant formula.
     */
    public Constant(boolean constant) {
        this.constant = constant;
    }

    /**
     * Get constant boolean.
     *
     * @return constant boolean.
     */
    public boolean isConstant() {
        return constant;
    }

    /**
     * Override toString of Constant model.
     *
     * @return string representation of Constant model.
     */
    @Override
    public String toString() {
        return constant ? "true" : "false";
    }

    /**
     * Call visitor of Constant model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitConstant(this);
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
        Constant constant1 = (Constant) o;
        return constant == constant1.constant;
    }

    /**
     * Override calculate hashCode of Constant model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(constant);
    }
}
