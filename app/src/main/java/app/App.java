package app;

import helpers.CTLHelper;

import java.io.IOException;

/**
 * App reads user's args inputs and pass them to CTL Helper
 */
public class App {
    /**
     * Read user's inputs and call CTL Helper
     *
     * @param args kripke, formula and output file names
     * @throws IOException input/output exception
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: 3 file names are required (kripke and formula and output)");
        }
        else {
            String kripkeFileName = args[0];
            String formulaFileName = args[1];
            String outputFileName = args[2];
            CTLHelper.check(kripkeFileName, formulaFileName, outputFileName);
        }
    }
}
