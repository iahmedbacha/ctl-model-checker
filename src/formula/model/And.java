package formula.model;

public class And extends Formula {
    private Formula left;
    private Formula right;

    public And(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " & " + right.toString();
    }
}
