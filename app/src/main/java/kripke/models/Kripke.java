package kripke.models;

import java.util.Map;
import java.util.Set;

/**
 * Kripke model
 */
public class Kripke {
    /**
     * States.
     */
    private final Map<String, State> states;
    /**
     * Initial states.
     */
    private final Set<State> initialStates;
    /**
     * Transitions.
     */
    private final Map<State, Set<State>> transitions;
    /**
     * Interpretations.
     */
    private final Map<State, Set<Proposition>> interpretations;

    /**
     * Construct Kripke model.
     *
     * @param states states
     * @param initialStates initialStates
     * @param transitions transitions
     * @param interpretations interpretations
     */
    public Kripke(Map<String, State> states, Set<State> initialStates, Map<State, Set<State>> transitions, Map<State, Set<Proposition>> interpretations) {
        this.states = states;
        this.initialStates = initialStates;
        this.transitions = transitions;
        this.interpretations = interpretations;
    }

    /**
     * Get states.
     *
     * @return states.
     */
    public Map<String, State> getStates() {
        return states;
    }

    /**
     * Get transitions.
     *
     * @return transitions.
     */
    public Map<State, Set<State>> getTransitions() {
        return transitions;
    }

    /**
     * Check if a state have a proposition with a certain designation.
     *
     * @param state state to check
     * @param designation designation to look for
     * @return transitions.
     */
    public boolean isProposition(State state, String designation) {
        if (interpretations.containsKey(state)) {
            return interpretations.get(state).contains(new Proposition(designation));
        }
        return false;
    }

    /**
     * Override toString of Kripke model.
     *
     * @return string representation of Kripke model.
     */
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
