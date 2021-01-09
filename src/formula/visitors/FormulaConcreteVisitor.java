package formula.visitors;

import formula.models.*;
import kripke.models.Kripke;
import kripke.models.Labeling;
import kripke.models.State;

import java.util.HashMap;
import java.util.Map;

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

    void putEvaluation (State state, Formula formula, boolean bool) {
        if (evaluations.containsKey(state)) {
            evaluations.get(state).put(formula, bool);
        }
        else {
            Map<Formula, Boolean> formulas = new HashMap<>();
            formulas.put(formula, bool);
            evaluations.put(state, formulas);
        }
    }

    boolean isEvaluated (Formula formula) {
        for (State state : evaluations.keySet()) {
            return evaluations.get(state).containsKey(formula);
        }
        return false;
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
        if (!isEvaluated(negation)) {
            Formula formula = negation.getFormula();
            formula.accept(this);
            for (State state : kripke.getStates().values()) {
                putEvaluation(state, negation, !evaluations.get(state).get(formula));
            }
        }
    }

    @Override
    public void visitProposition(Proposition proposition) {
        if (!isEvaluated(proposition)) {
            for (State state : kripke.getStates().values()) {
                Labeling labeling = kripke.getLabeling();
                putEvaluation(state, proposition, labeling.isProposition(state, proposition.getDesignation()));
            }
        }
    }

    @Override
    public void visitConstant(Constant constant) {
        if (!isEvaluated(constant)) {
            for (State state : kripke.getStates().values()) {
                putEvaluation(state, constant, constant.isConstant());
            }
        }
    }
}
