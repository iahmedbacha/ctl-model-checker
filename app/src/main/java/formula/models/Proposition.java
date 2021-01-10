package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * Proposition model: designation
 */
public class Proposition extends Formula {
    /**
     * Designation string.
     */
    private final String designation;

    /**
     * Construct Proposition model.
     *
     * @param designation string.
     */
    public Proposition(String designation) {
        this.designation = designation;
    }

    /**
     * Get designation string.
     *
     * @return designation string.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Override toString of Proposition model.
     *
     * @return string representation of Proposition model.
     */
    @Override
    public String toString() {
        return designation;
    }

    /**
     * Call visitor of Proposition model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitProposition(this);
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
        Proposition that = (Proposition) o;
        return Objects.equals(designation, that.designation);
    }

    /**
     * Calculate hashCode of Proposition model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
