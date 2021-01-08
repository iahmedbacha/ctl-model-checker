package formula.model;

public class EX extends Formula {
    private Formula formula;

    public EX(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "E X ( " + formula.toString() + " )";
    }
}
