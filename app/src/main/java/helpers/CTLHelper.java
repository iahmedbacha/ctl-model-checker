package helpers;

import formula.factories.FormulaSimpleFactory;
import formula.models.Formula;
import formula.visitors.CTLTranspilerConcreteVisitor;
import formula.visitors.FormulaConcreteVisitor;
import kripke.factories.KripkeSimpleFactory;
import kripke.models.Kripke;
import kripke.models.State;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Map;

/**
 * CTLHelper handles input and output operations
 */
public class CTLHelper {
    /**
     * Check a formula
     *
     * @param kripkeFileName kripke file name
     * @param formulaFileName formula file name
     * @param outputFileName output file name
     * @throws IOException input/output exception
     */
    public static void check (String kripkeFileName, String formulaFileName, String outputFileName) throws IOException {
        FastScanner fastScanner = new FastScanner(outputFileName, false);
        Kripke kripke = KripkeSimpleFactory.getKripke(kripkeFileName);
        String transpiledFormula = transpile(formulaFileName);
        Formula formula = FormulaSimpleFactory.getFormula(transpiledFormula);
        FormulaConcreteVisitor formulaConcreteVisitor = new FormulaConcreteVisitor(kripke);
        formula.accept(formulaConcreteVisitor);
        Map<State, Map<Formula, Boolean>> evaluations = formulaConcreteVisitor.getEvaluations();
        for (State state : evaluations.keySet()) {
            if (evaluations.get(state).get(formula)) {
                fastScanner.print(state.getDesignation()+" ");
            }
        }
        fastScanner.println("");
        fastScanner.flush();
        fastScanner.close();
    }

    /**
     * transpile a formula
     *
     * @param formulaFileName formula file name
     * @throws IOException input/output exception
     */
    private static String transpile (String formulaFileName) throws IOException {
        ParseTree parseTree = FormulaSimpleFactory.getParseTreeFromFileName(formulaFileName);
        CTLTranspilerConcreteVisitor ctlTranspilerConcreteVisitor = new CTLTranspilerConcreteVisitor();
        return ctlTranspilerConcreteVisitor.visit(parseTree);
    }
}
