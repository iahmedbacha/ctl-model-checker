package formula;

public class EU extends Formula {
    private Formula left;
    private Formula right;

    public EU(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "E " + left.toString() + " U ( " + right.toString() + " )";
    }
}
