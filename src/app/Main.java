package app;

import antlr.CTLLexer;
import antlr.CTLParser;
import formula.Formula;
import helpers.AntlrToFormula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: file name");
        }
        else {
            String fileName = args[0];
            CTLParser parser = getParser(fileName);
            ParseTree antlrAST = parser.formula();
            AntlrToFormula FormulaVisitor = new AntlrToFormula();
            Formula formula = FormulaVisitor.visit(antlrAST);
        }
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
