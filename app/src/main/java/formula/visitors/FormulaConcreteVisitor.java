package formula.visitors;

import formula.models.*;
import kripke.models.Kripke;
import kripke.models.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FormulaConcreteVisitor evaluates a formula object
 */

public class FormulaConcreteVisitor extends FormulaVisitor {
    /**
     * Kripke object
     */
    final private Kripke kripke;
    /**
     * Evaluations object
     */
    final private Map<State, Map<Formula, Boolean>> evaluations;

    /**
     * Construct Formula concrete visitor.
     *
     * @param kripke kripke object.
     */
    public FormulaConcreteVisitor(Kripke kripke) {
        this.kripke = kripke;
        this.evaluations = new HashMap<>();
    }

    /**
     * Get evaluations.
     *
     * @return evaluations.
     */
    public Map<State, Map<Formula, Boolean>> getEvaluations() {
        return evaluations;
    }

    /**
     * Set evaluation of a formula in a state with boolean.
     *
     * @param state state
     * @param formula formula
     * @param bool boolean
     */
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

    /**
     * Get evaluation.
     *
     * @param state state
     * @param formula formula
     * @return evaluation.
     */
    Boolean getEvaluation (State state, Formula formula) {
        if (evaluations.containsKey(state)) {
            return evaluations.get(state).getOrDefault(formula, false);
        }
        return false;
    }

    /**
     * Check if a formula is already evaluated.
     *
     * @param formula formula
     * @return true if the formula is already evaluated, otherwise false.
     */
    boolean isEvaluated (Formula formula) {
        for (State state : evaluations.keySet()) {
            return evaluations.get(state).containsKey(formula);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate And formula
     */
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

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate AU formula
     */
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

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate EU formula
     */
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

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate EX formula
     */
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

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate Negation formula
     */
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

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate Negation formula
     */
    @Override
    public void visitProposition(Proposition proposition) {
        if (!isEvaluated(proposition)) {
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, proposition, kripke.isProposition(state, proposition.getDesignation()));
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * The concrete implementation evaluate True formula
     */
    @Override
    public void visitTrue(True aTrue) {
        if (!isEvaluated(aTrue)) {
            for (State state : kripke.getStates().values()) {
                setEvaluation(state, aTrue, true);
            }
        }
    }
}
