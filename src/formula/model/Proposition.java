package formula.model;

public class Proposition extends Formula {
    private String designation;

    public Proposition(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return designation;
    }
}
