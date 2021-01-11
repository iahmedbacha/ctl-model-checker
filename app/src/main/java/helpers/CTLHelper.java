package helpers;

import formula.factories.FormulaSimpleFactory;
import formula.models.Formula;
import formula.visitors.FormulaConcreteVisitor;
import kripke.factories.KripkeSimpleFactory;
import kripke.models.Kripke;
import kripke.models.State;

import java.io.IOException;
import java.util.Map;

public class CTLHelper {
    public static void check (String kripkeFileName, String formulaFileName, String outputFileName) throws IOException {
        FastScanner fastScanner = new FastScanner(outputFileName, false);
        Kripke kripke = KripkeSimpleFactory.getKripke(kripkeFileName);
        Formula formula = FormulaSimpleFactory.getFormula(formulaFileName);
        FormulaConcreteVisitor formulaConcreteVisitor = new FormulaConcreteVisitor(kripke);
        formula.accept(formulaConcreteVisitor);
        Map<State, Map<Formula, Boolean>> evaluations = formulaConcreteVisitor.getEvaluations();
        for (State state : evaluations.keySet()) {
            if (evaluations.get(state).get(formula)) {
                fastScanner.print(state.getDesignation()+" ");
            }
        }
        fastScanner.flush();
        fastScanner.close();
    }
}
