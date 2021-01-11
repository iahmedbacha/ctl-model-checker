package formula.models;

import formula.visitors.FormulaVisitor;

/**
 * True model: true
 */
public class True extends Formula {
    /**
     * Override toString of True model.
     *
     * @return string representation of True model.
     */
    @Override
    public String toString() {
        return "true";
    }

    /**
     * Call visitor of True model.
     *
     */
    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitTrue(this);
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
        return o != null && getClass() == o.getClass();
    }

    /**
     * Override calculate hashCode of True model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
