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
     */
    public static Formula getFormula (String fileName) {
        CTLParser parser = getParser(fileName);
        ParseTree antlrAST = parser.formula();
        CTLConcreteVisitor CTLConcreteVisitor = new CTLConcreteVisitor();
        Formula formula = CTLConcreteVisitor.visit(antlrAST);
        return formula;
    }

    /**
     * Get parser based on fileName
     *
     * @param fileName fileName of ctl formula file
     * @return parser object
     */
    private static CTLParser getParser(String fileName) {
        CTLParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            CTLLexer lexer = new CTLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new CTLParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
