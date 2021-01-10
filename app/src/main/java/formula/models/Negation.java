package formula.models;

import formula.visitors.FormulaVisitor;

public class Negation extends Formula {
    private final Formula formula;

    public Negation(Formula formula) {
        this.formula = formula;
    }

    public Formula getFormula() {
        return formula;
    }

    @Override
    public String toString() {
        return "! ( " + formula.toString() + " )";
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitNegation(this);
    }
}
