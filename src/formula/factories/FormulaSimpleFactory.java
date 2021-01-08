package formula.factories;

import antlr.CTLLexer;
import antlr.CTLParser;
import formula.models.Formula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import formula.visitors.CTLConcreteVisitor;

import java.io.IOException;

public class FormulaSimpleFactory {
    public static Formula getFormula (String fileName) {
        CTLParser parser = getParser(fileName);
        ParseTree antlrAST = parser.formula();
        CTLConcreteVisitor CTLConcreteVisitor = new CTLConcreteVisitor();
        Formula formula = CTLConcreteVisitor.visit(antlrAST);
        return formula;
    }

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
