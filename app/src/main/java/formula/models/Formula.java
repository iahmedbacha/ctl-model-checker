package formula.models;

import formula.visitors.FormulaVisitor;

/**
 * Formula model: abstraction for all formula models
 */
public abstract class Formula {
    /**
     * Call visitor of Formula model.
     *
     * @param formulaVisitor formula visitor
     */
    abstract public void accept(FormulaVisitor formulaVisitor);

    /**
     * Compare with another object.
     *
     * @param obj object to compare with
     * @return equals boolean
     */
    @Override
    abstract public boolean equals(Object obj);

    /**
     * Override calculate hashCode of Formula model.
     *
     * @return hashCode
     */
    @Override
    abstract public int hashCode();
}
