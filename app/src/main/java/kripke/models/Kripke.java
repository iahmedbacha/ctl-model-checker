package kripke.models;

import java.util.Map;
import java.util.Set;

public class Kripke {
    private Map<String, State> states;
    private Set<State> initialStates;
    private Map<State, Set<State>> transitions;
    private Map<State, Set<Proposition>> interpretations;

    public Kripke(Map<String, State> states, Set<State> initialStates, Map<State, Set<State>> transitions, Map<State, Set<Proposition>> interpretations) {
        this.states = states;
        this.initialStates = initialStates;
        this.transitions = transitions;
        this.interpretations = interpretations;
    }

    public Map<String, State> getStates() {
        return states;
    }

    public Map<State, Set<State>> getTransitions() {
        return transitions;
    }

    public boolean isProposition(State state, String designation) {
        if (interpretations.containsKey(state)) {
            return interpretations.get(state).contains(new Proposition(designation));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Kripke{" +
                "states=" + states +
                ", initialStates=" + initialStates +
                ", transitions=" + transitions +
                ", interpretations=" + interpretations +
                '}';
    }
}
