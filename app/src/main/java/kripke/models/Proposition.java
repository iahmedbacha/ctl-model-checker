package kripke.models;

import java.util.Objects;

/**
 * Proposition model
 */
public class Proposition {
    /**
     * Designation string
     */
    private final String designation;

    /**
     * Construct Proposition model.
     *
     * @param designation string.
     */
    public Proposition(String designation) {
        this.designation = designation;
    }

    /**
     * Override toString of Proposition model.
     *
     * @return string representation of Proposition model.
     */
    @Override
    public String toString() {
        return "Proposition ( " + designation + " )";
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
        Proposition that = (Proposition) o;
        return Objects.equals(designation, that.designation);
    }

    /**
     * Override calculate hashCode of Proposition model.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
