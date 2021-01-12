package formula.factories;

import antlr.CTLLexer;
import antlr.CTLParser;
import formula.models.Formula;
import formula.visitors.CTLASTToFormulaConcreteVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * FormulaSimpleFactory creates a formula object
 */
public class FormulaSimpleFactory {
    /**
     * Get formula based on ctl formula
     *
     * @param string ctl formula
     * @return formula object
     */
    public static Formula getFormula(String string) {
        ParseTree parseTree = getParseTreeFromString(string);
        CTLASTToFormulaConcreteVisitor CTLASTToFormulaConcreteVisitor = new CTLASTToFormulaConcreteVisitor();
        return CTLASTToFormulaConcreteVisitor.visit(parseTree);
    }

    /**
     * Get parser tree based on fileName
     *
     * @param fileName fileName of ctl formula file
     * @return parseTree object
     * @throws IOException input/output exception
     */
    public static ParseTree getParseTreeFromFileName(String fileName) throws IOException {
        CharStream input = CharStreams.fromFileName(fileName);
        CTLLexer lexer = new CTLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CTLParser parser = new CTLParser(tokens);
        return parser.formula();
    }

    /**
     * Get parser tree based on ctl formula
     *
     * @param string ctl formula
     * @return parseTree object
     */
    public static ParseTree getParseTreeFromString(String string) {
        CharStream input = CharStreams.fromString(string);
        CTLLexer lexer = new CTLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CTLParser parser = new CTLParser(tokens);
        return parser.formula();
    }
}
