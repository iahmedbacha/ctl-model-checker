package kripke.factories;

import helpers.FastScanner;
import kripke.models.Kripke;
import kripke.models.Proposition;
import kripke.models.State;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KripkeSimpleFactory {
    public static Kripke getKripke (String fileName) {
        Kripke kripke = null;
        try {
            FastScanner fastScanner = new FastScanner(fileName, true);
            int n = fastScanner.nextInt();
            Map<String, State> states = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                String designation = fastScanner.nextString();
                State state = new State(designation);
                states.put(state.getDesignation(), state);
            }
            int m = fastScanner.nextInt();
            Set<State> initialStates = new HashSet<>(m);
            for (int i = 0; i < m; i++) {
                String designation = fastScanner.nextString();
                State state = states.get(designation);
                initialStates.add(state);
            }
            int x = fastScanner.nextInt();
            Map<State, Set<State>> transitions = new HashMap<>(x);
            for (int i = 0; i < x; i++) {
                String designationSource = fastScanner.nextString();
                String designationDestination = fastScanner.nextString();
                State source = states.get(designationSource);
                State destination = states.get(designationDestination);
                if (transitions.containsKey(source)) {
                    transitions.get(source).add(destination);
                }
                else {
                    Set<State> set = new HashSet<>();
                    set.add(destination);
                    transitions.put(source, set);
                }
            }
            int y = fastScanner.nextInt();
            Map<State, Set<Proposition>> interpretations = new HashMap<>(y);
            for (int i = 0; i < y; i++) {
                String designation = fastScanner.nextString();
                State state = states.get(designation);
                int z = fastScanner.nextInt();
                Set<Proposition> propositions = new HashSet<>(z);
                for (int j = 0; j < z; j++) {
                    String designationProposition = fastScanner.nextString();
                    Proposition proposition = new Proposition(designationProposition);
                    propositions.add(proposition);
                }
                interpretations.put(state, propositions);
            }
            kripke =  new Kripke(states, initialStates, transitions, interpretations);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kripke;
    }
}
