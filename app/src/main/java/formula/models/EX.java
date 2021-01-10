package formula.models;

import formula.visitors.FormulaVisitor;

public class EX extends Formula {
    private final Formula formula;

    public EX(Formula formula) {
        this.formula = formula;
    }

    public Formula getFormula() {
        return formula;
    }

    @Override
    public String toString() {
        return "E X ( " + formula.toString() + " )";
    }

    @Override
    public void accept(FormulaVisitor formulaVisitor) {
        formulaVisitor.visitEX(this);
    }
}
