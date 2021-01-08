package formula.model;

public class Negation extends Formula {
    private Formula formula;

    public Negation(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "! ( " + formula.toString() + " )";
    }
}
