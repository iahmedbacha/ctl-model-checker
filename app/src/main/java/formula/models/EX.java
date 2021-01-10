package formula.models;

import formula.visitors.FormulaVisitor;

import java.util.Objects;

/**
 * EX model: EX ( formula )
 */
public class EX extends Formula {
    /**
     * formula.
     */
    private final Formula formula;

    /**
     * Construct EX model.
     *
     * @param formula formula.
     */
    public EX(Formula formula) {
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
     * Override toString of EX model.
     *
     * @return string representation of EX model.
     */
    @Override
    public String toString() {
        return "E X ( " + formula.toString() + " )";
    }

    /**
     * Call visitor of EX model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitEX(this);
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
        EX ex = (EX) o;
        return Objects.equals(formula, ex.formula);
    }

    /**
     * Override calculate hashCode of EX model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(formula);
    }
}
