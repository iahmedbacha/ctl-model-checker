package kripke;

public class Transition {
    private State source;
    private State destination;

    public Transition(State source, State destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Transition  ( " + source + " , " + destination + " )";
    }
}
