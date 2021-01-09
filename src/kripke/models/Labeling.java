package kripke.models;

import java.util.Map;

public class Labeling {
    final private Map<State, Map<String, Proposition>> interpretations;

    public Labeling(Map<State, Map<String, Proposition>> interpretations) {
        this.interpretations = interpretations;
    }

    public boolean isProposition(State state, String designation) {
        if (interpretations.containsKey(state)) {
            return interpretations.get(state).containsKey(designation);
        }
        return false;
    }

    public Map<State, Map<String, Proposition>> getInterpretations() {
        return interpretations;
    }

    @Override
    public String toString() {
        return "Labeling{" +
                "interpretations=" + interpretations +
                '}';
    }
}
