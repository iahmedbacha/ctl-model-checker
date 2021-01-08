package formula;

public class Proposition extends Formula {
    private String label;

    public Proposition(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
