package formula.model;

public class Constant extends Formula {
    private boolean constant;

    public Constant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant ? "true" : "false";
    }
}
