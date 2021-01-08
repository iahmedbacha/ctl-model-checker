package app;

import factories.FormulaSimpleFactory;
import formula.Formula;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: file name");
        }
        else {
            String fileName = args[0];
            Formula formula = FormulaSimpleFactory.getFormula(fileName);

        }
    }
}
