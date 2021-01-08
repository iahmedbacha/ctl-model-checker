package kripke;

import java.util.HashMap;
import java.util.HashSet;

public class Labeling {
    private HashMap<State, HashSet<Proposition>> hashMap;

    public Labeling(HashMap<State, HashSet<Proposition>> hashMap) {
        this.hashMap = hashMap;
    }
}
