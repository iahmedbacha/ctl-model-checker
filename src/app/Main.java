package app;

import formula.factories.FormulaSimpleFactory;
import kripke.factories.KripkeSimpleFactory;
import formula.models.Formula;
import kripke.models.Kripke;

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
        }
    }
}
