package formula.factories;

import antlr.CTLLexer;
import antlr.CTLParser;
import formula.models.Formula;
import formula.visitors.CTLConcreteVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Formula simple factory: create formula object
 */
public class FormulaSimpleFactory {
    /**
     * Get formula based on fileName
     *
     * @param fileName fileName of formula file
     * @return formula object
     * @throws IOException input/output exception
     */
    public static Formula getFormula (String fileName) throws IOException {
        CTLParser parser = getParser(fileName);
        ParseTree antlrAST = parser.formula();
        CTLConcreteVisitor CTLConcreteVisitor = new CTLConcreteVisitor();
        return CTLConcreteVisitor.visit(antlrAST);
    }

    /**
     * Get parser based on fileName
     *
     * @param fileName fileName of ctl formula file
     * @return parser object
     * @throws IOException input/output exception
     */
    private static CTLParser getParser(String fileName) throws IOException {
        CharStream input = CharStreams.fromFileName(fileName);
        CTLLexer lexer = new CTLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new CTLParser(tokens);
    }
}
