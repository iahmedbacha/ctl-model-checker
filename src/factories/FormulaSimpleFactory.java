package factories;

import antlr.CTLLexer;
import antlr.CTLParser;
import formula.Formula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.FormulaVisitor;

import java.io.IOException;

public class FormulaSimpleFactory {
    public static Formula getFormula (String fileName) {
        CTLParser parser = getParser(fileName);
        ParseTree antlrAST = parser.formula();
        FormulaVisitor FormulaVisitor = new FormulaVisitor();
        Formula formula = FormulaVisitor.visit(antlrAST);
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
