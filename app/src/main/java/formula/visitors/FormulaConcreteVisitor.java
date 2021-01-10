package formula.visitors;

import formula.models.*;
import kripke.models.Kripke;
import kripke.models.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FormulaConcreteVisitor extends FormulaVisitor {
    final private Kripke kripke;
    final private Map<State, Map<Formula, Boolean>> evaluations;

    public FormulaConcreteVisitor(Kripke kripke) {
        this.kripke = kripke;
        this.evaluations = new HashMap<>();
    }

    public Map<State, Map<Formula, Boolean>> getEvaluations() {
        return evaluations;
    }

    void setEvaluation(State state, Formula formula, boolean bool) {
        if (evaluations.containsKey(state)) {
            evaluations.get(state).put(formula, bool);
        }
        else {
            Map<Formula, Boolean> formulas = new HashMap<>();
            formulas.put(formula, bool);
            evaluations.put(state, formulas);
        }
    }

    Boolean getEvaluation (State state, Formula formula) {
        if (evaluations.containsKey(state)) {
            return evaluations.get(state).getOrDefault(formula, false);
        }
        return false;
    }

    boolean isEvaluated (Formula formula) {
        for (State state : evaluations.keySet()) {
            return evaluations.get(state).containsKey(formula);
        }
        return false;
    }

    @Override
    public void visitAnd(And and) {
        if (!isEvaluated(and)) {
            Formula left = and.getLeft();
            Formula right = and.getRight();
            left.accept(this);
            right.accept(this);
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, and, getEvaluation(state, left) && getEvaluation(state, right));
            }
        }
    }

    @Override
    public void visitAU(AU au) {
        if (!isEvaluated(au)) {
            Formula left = au.getLeft();
            Formula right = au.getRight();
            left.accept(this);
            right.accept(this);
            Set<State> L = new HashSet<>();
            Map<State, Integer> nb = new HashMap<>();
            Map<State, Set<State>> transitions = kripke.getTransitions();
            for (State state : kripke.getStates().values()) {
                nb.put(state, transitions.get(state).size());
                setEvaluation(state, au, false);
                if (getEvaluation(state, right)) {
                    L.add(state);
                }
            }
            while (L.size() > 0) {
                for (State state : L) {
                    setEvaluation(state, au, true);
                    for (State source : transitions.keySet()) {
                        for (State destination : transitions.get(source)) {
                            if (destination == state) {
                                nb.put(source, nb.get(source) - 1);
                                if (nb.get(source) == 0 && getEvaluation(source, left) && !getEvaluation(source, au)) {
                                    L.add(source);
                                }
                            }
                        }
                    }
                    L.remove(state);
                    break;
                }
            }
        }
    }

    @Override
    public void visitEU(EU eu) {
        if (!isEvaluated(eu)) {
            Formula left = eu.getLeft();
            Formula right = eu.getRight();
            left.accept(this);
            right.accept(this);
            Map<State, Boolean> seenBefore = new HashMap<>();
            Set<State> L = new HashSet<>();
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, eu, false);
                seenBefore.put(state, false);
                if (getEvaluation(state, right)) {
                    L.add(state);
                }
            }
            while (L.size() > 0) {
                for (State state : L) {
                    setEvaluation(state, eu, true);
                    Map<State, Set<State>> transitions = kripke.getTransitions();
                    for (State source : transitions.keySet()) {
                        for (State destination : transitions.get(source)) {
                            if (destination == state && !seenBefore.get(source)) {
                                seenBefore.put(source, true);
                                if (getEvaluation(source, left)) {
                                    L.add(source);
                                }
                            }
                        }
                    }
                    L.remove(state);
                    break;
                }
            }
        }
    }

    @Override
    public void visitEX(EX ex) {
        if (!isEvaluated(ex)) {
            Formula formula = ex.getFormula();
            formula.accept(this);
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, ex, false);
            }
            Map<State, Set<State>> transitions = kripke.getTransitions();
            for (State source : transitions.keySet()) {
                setEvaluation(source, ex, false);
                for (State destination : transitions.get(source)) {
                    if (getEvaluation(destination, formula)) {
                        setEvaluation(source, ex, true);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void visitNegation(Negation negation) {
        if (!isEvaluated(negation)) {
            Formula formula = negation.getFormula();
            formula.accept(this);
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, negation, !getEvaluation(state, formula));
            }
        }
    }

    @Override
    public void visitProposition(Proposition proposition) {
        if (!isEvaluated(proposition)) {
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, proposition, kripke.isProposition(state, proposition.getDesignation()));
            }
        }
    }

    @Override
    public void visitConstant(Constant constant) {
        if (!isEvaluated(constant)) {
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, constant, constant.isConstant());
            }
        }
    }
}
