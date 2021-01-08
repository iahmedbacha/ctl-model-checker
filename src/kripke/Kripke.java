package kripke;

import java.util.List;

public class Kripke {
    private List<State> states;
    private List<State> initialStates;
    private List<Transition> transitions;
    private Labeling labeling;

    public Kripke(List<State> states, List<State> initialStates, List<Transition> transitions, Labeling labeling) {
        this.states = states;
        this.initialStates = initialStates;
        this.transitions = transitions;
        this.labeling = labeling;
    }
}
