package kripke.models;

import java.util.Objects;

public class Proposition {
    private final String designation;

    public Proposition(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Proposition ( " + designation + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposition that = (Proposition) o;
        return Objects.equals(designation, that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
