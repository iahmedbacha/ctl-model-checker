package kripke.models;

import java.util.Map;
import java.util.Set;

public class Kripke {
    private Map<String, State> states;
    private Set<State> initialStates;
    private Map<State, Set<State>> transitions;
    private Labeling labeling;

    public Kripke(Map<String, State> states, Set<State> initialStates, Map<State, Set<State>> transitions, Labeling labeling) {
        this.states = states;
        this.initialStates = initialStates;
        this.transitions = transitions;
        this.labeling = labeling;
    }

    public Map<String, State> getStates() {
        return states;
    }

    public Labeling getLabeling() {
        return labeling;
    }

    @Override
    public String toString() {
        return "Kripke{" +
                "states=" + states +
                ", initialStates=" + initialStates +
                ", transitions=" + transitions +
                ", labeling=" + labeling +
                '}';
    }
}
