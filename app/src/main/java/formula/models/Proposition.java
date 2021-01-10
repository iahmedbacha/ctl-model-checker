package formula.models;

import formula.visitors.FormulaVisitor;

public class Proposition extends Formula {
    private final String designation;

    public Proposition(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return designation;
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitProposition(this);
    }
}
