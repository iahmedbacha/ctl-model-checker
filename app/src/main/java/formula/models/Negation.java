package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * Negation model: ! ( formula )
 */
public class Negation extends Formula {
    /**
     * formula.
     */
    private final Formula formula;

    /**
     * Construct Negation model.
     *
     * @param formula formula.
     */
    public Negation(Formula formula) {
        this.formula = formula;
    }

    /**
     * Get formula.
     *
     * @return formula.
     */
    public Formula getFormula() {
        return formula;
    }

    /**
     * Override toString of Negation model.
     *
     * @return string representation of Negation model.
     */
    @Override
    public String toString() {
        return "! ( " + formula.toString() + " )";
    }

    /**
     * Call visitor of Negation model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitNegation(this);
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
        Negation negation = (Negation) o;
        return Objects.equals(formula, negation.formula);
    }

    /**
     * Calculate hashCode of Negation model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(formula);
    }
}
