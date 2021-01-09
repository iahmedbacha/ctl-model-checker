package app;

import formula.factories.FormulaSimpleFactory;
import formula.models.Formula;
import formula.visitors.FormulaConcreteVisitor;
import kripke.factories.KripkeSimpleFactory;
import kripke.models.Kripke;
import kripke.models.State;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: 2 file names are required (kripke and formula)");
        }
        else {
            String kripkeFileName = args[0];
            String FormulaFileName = args[1];
            Kripke kripke = KripkeSimpleFactory.getKripke(kripkeFileName);
            Formula formula = FormulaSimpleFactory.getFormula(FormulaFileName);
            FormulaConcreteVisitor formulaConcreteVisitor = new FormulaConcreteVisitor(kripke);
            formula.accept(formulaConcreteVisitor);
            Map<State, Map<Formula, Boolean>> evaluations = formulaConcreteVisitor.getEvaluations();
            for (State state : evaluations.keySet()) {
                if (evaluations.get(state).containsKey(formula)) {
                    if (evaluations.get(state).get(formula)) {
                        System.out.println(state);
                    }
                }
            }
        }
    }
}
