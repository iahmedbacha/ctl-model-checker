package kripke;

public class State {
    private String designation;

    public State(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "State ( " + designation + " )";
    }
}
