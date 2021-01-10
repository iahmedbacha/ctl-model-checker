package kripke.models;

import java.util.Objects;

public class State {
    private final String designation;

    public State(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "State ( " + designation + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(designation, state.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
