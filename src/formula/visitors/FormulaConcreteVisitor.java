package formula.visitors;

import formula.models.*;
import kripke.models.Kripke;
import kripke.models.Labeling;
import kripke.models.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FormulaConcreteVisitor extends FormulaVisitor {
    private Kripke kripke;
    private Map<State, Set<Formula>> evaluations;

    public FormulaConcreteVisitor(Kripke kripke) {
        this.kripke = kripke;
        this.evaluations = new HashMap<>();
    }

    public Map<State, Set<Formula>> getEvaluations() {
        return evaluations;
    }

    void addEvaluation (State state, Formula formula) {
        if (evaluations.containsKey(state)) {
            evaluations.get(state).add(formula);
        }
        else {
            Set<Formula> formulas = new HashSet<>();
            formulas.add(formula);
            evaluations.put(state, formulas);
        }
    }

    void removeEvaluation (State state, Formula formula) {
        if (evaluations.containsKey(state)) {
            evaluations.get(state).remove(formula);
        }
    }

    @Override
    public void visitAnd(And and) {

    }

    @Override
    public void visitAU(AU au) {

    }

    @Override
    public void visitEU(EU eu) {

    }

    @Override
    public void visitEX(EX ex) {

    }

    @Override
    public void visitNegation(Negation negation) {

    }

    @Override
    public void visitProposition(Proposition proposition) {
        for (State state : kripke.getStates().values()) {
            Labeling labeling = kripke.getLabeling();
            if (labeling.isProposition(state, proposition.getDesignation())) {
                addEvaluation(state, proposition);
            }
            else {
                removeEvaluation(state, proposition);
            }
        }
    }

    @Override
    public void visitConstant(Constant constant) {
        for (State state : kripke.getStates().values()) {
            addEvaluation(state, constant);
        }
    }
}
