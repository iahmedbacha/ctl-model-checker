package formula.models;

import formula.visitors.FormulaVisitor;

public class Proposition extends Formula {
    private String designation;

    public Proposition(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return designation;
    }

    @Override
    void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitProposition(this);
    }
}