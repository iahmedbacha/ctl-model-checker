package formula.visitors;

import formula.models.*;

/**
 * FormulaVisitor defines a complete generic visitor for formula objects
 */
public abstract class FormulaVisitor {
    /**
     * Override visit And object
     *
     * @param and And object
     */
    public abstract void visitAnd(And and);

    /**
     * Override visit AU object
     *
     * @param au AU object
     */
    public abstract void visitAU(AU au);

    /**
     * Override visit EU object
     *
     * @param eu EU object
     */
    public abstract void visitEU(EU eu);

    /**
     * Override visit EX object
     *
     * @param ex EX object
     */
    public abstract void visitEX(EX ex);

    /**
     * Override visit Negation object
     *
     * @param negation Negation object
     */
    public abstract void visitNegation(Negation negation);

    /**
     * Override visit Proposition object
     *
     * @param proposition Proposition object
     */
    public abstract void visitProposition(Proposition proposition);

    /**
     * Override visit Constant object
     *
     * @param constant Constant object
     */
    public abstract void visitConstant(Constant constant);
}
