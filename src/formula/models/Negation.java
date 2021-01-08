package formula.models;

import formula.visitors.FormulaVisitor;

public class Negation extends Formula {
    private Formula formula;

    public Negation(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "! ( " + formula.toString() + " )";
    }

    @Override
    void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitNegation(this);
    }
}