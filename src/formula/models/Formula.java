package formula.models;

import formula.visitors.FormulaVisitor;

public abstract class Formula {
    abstract void accept(FormulaVisitor formulaVisitor);
}
