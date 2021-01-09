package formula.models;

import formula.visitors.FormulaVisitor;

public abstract class Formula {
    abstract public void accept(FormulaVisitor formulaVisitor);

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}
