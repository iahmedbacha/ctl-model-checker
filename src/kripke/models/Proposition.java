package kripke.models;

public class Proposition {
    private String designation;

    public Proposition(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Proposition ( " + designation + " )";
    }
}
