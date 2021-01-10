package kripke.models;

import java.util.Objects;

/**
 * State model
 */
public class State {
    /**
     * Designation string
     */
    private final String designation;

    /**
     * Construct State model.
     *
     * @param designation string.
     */
    public State(String designation) {
        this.designation = designation;
    }

    /**
     * Get designation string.
     *
     * @return designation string.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Override toString of State model.
     *
     * @return string representation of State model.
     */
    @Override
    public String toString() {
        return "State ( " + designation + " )";
    }

    /**
     * Override compare with another object.
     *
     * @param o object to compare with
     * @return equals boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(designation, state.designation);
    }

    /**
     * Override calculate hashCode of State model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
