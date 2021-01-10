package app;

import helpers.CTLChecker;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: 3 file names are required (kripke and formula and output)");
        }
        else {
            String kripkeFileName = args[0];
            String formulaFileName = args[1];
            String outputFileName = args[2];
            CTLChecker.check(kripkeFileName, formulaFileName, outputFileName);
        }
    }
}
