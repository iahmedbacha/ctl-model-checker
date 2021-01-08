package kripke.models;

import java.util.Map;
import java.util.Set;

public class Labeling {
    private Map<State, Set<Proposition>> interpretations;

    public Labeling(Map<State, Set<Proposition>> interpretations) {
        this.interpretations = interpretations;
    }

    @Override
    public String toString() {
        return "Labeling{" +
                "interpretations=" + interpretations +
                '}';
    }
}
