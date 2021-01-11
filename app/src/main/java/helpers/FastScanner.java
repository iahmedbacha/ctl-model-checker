package helpers;

import java.io.*;
import java.util.StringTokenizer;

/**
 * FastScanner handles input and output operations
 */
public class FastScanner {
    /**
     * Input buffer.
     */
    private final BufferedReader in;

    /**
     * Output buffer.
     */
    private final BufferedWriter out;

    /**
     * String tokenizer.
     */
    private StringTokenizer st;

    /**
     * Construct FastScanner with System.in and System.out.
     *
     */
    public FastScanner () {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /**
     * Construct FastScanner with fileName for either input or output.
     *
     * @param fileName name of the file
     * @param bool true if fileName is for input, otherwise fileName is for output
     */
    public FastScanner (String fileName, boolean bool) throws IOException {
        if (bool) {
            this.in = new BufferedReader(new FileReader(fileName));
            this.out = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        else {
            in = new BufferedReader(new InputStreamReader(System.in));
            this.out = new BufferedWriter(new FileWriter(fileName));
        }
    }

    /**
     * Construct FastScanner with in for input and out for output.
     *
     * @param in name of the input file
     * @param out name of the output file
     */
    public FastScanner (String in, String out) throws IOException {
        this.in = new BufferedReader(new FileReader(in));
        this.out = new BufferedWriter(new FileWriter(out));
    }

    /**
     * Get next line.
     *
     * @return next line
     */
    public String nextLine () throws IOException {
        return in.readLine();
    }

    /**
     * Get next string.
     *
     * @return next string
     */
    public String nextString () throws IOException {
        while ((st == null) || (!st.hasMoreTokens())) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    /**
     * Get next integer.
     *
     * @return next integer
     */
    public int nextInt () throws IOException {
        return Integer.parseInt(nextString());
    }

    /**
     * Get next long integer.
     *
     * @return next long integer
     */
    public long nextLong () throws IOException {
        return Long.parseLong(nextString());
    }

    /**
     * Get next double.
     *
     * @return next double
     */
    public double nextDouble () throws IOException {
        return Double.parseDouble(nextString());
    }

    /**
     * Print string to the output with new line.
     *
     */
    public void println (String string) throws IOException {
        out.write(string);
        out.newLine();
    }

    /**
     * Print string to the output without new line.
     *
     */
    public void print (String string) throws IOException {
        out.write(string);
    }

    /**
     * Flush the buffer to the output.
     *
     */
    public void flush () throws IOException {
        out.flush();
    }

    /**
     * Close input and output.
     *
     */
    public void  close () throws IOException {
        in.close();
        out.close();
    }
}
