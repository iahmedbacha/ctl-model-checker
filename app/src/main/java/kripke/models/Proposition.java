package kripke.models;

import java.util.Objects;

public class Proposition {
    private String designation;

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
        return designation.equals(that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
