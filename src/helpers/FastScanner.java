package helpers;

import java.io.*;
import java.util.StringTokenizer;

public class FastScanner {
    private BufferedReader in;
    private BufferedWriter out;
    private StringTokenizer st;

    public FastScanner () {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public FastScanner (String in) throws IOException {
        this.in = new BufferedReader(new FileReader(in));
        this.out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public FastScanner (String in, String out) throws IOException {
        this.in = new BufferedReader(new FileReader(in));
        this.out = new BufferedWriter(new FileWriter(out));
    }

    public String nextLine () throws IOException {
        return in.readLine();
    }

    public String nextString () throws IOException {
        while ((st == null) || (!st.hasMoreTokens())) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt () throws IOException {
        return Integer.parseInt(nextString());
    }

    public long nextLong () throws IOException {
        return Long.parseLong(nextString());
    }

    public double nextDouble () throws IOException {
        return Double.parseDouble(nextString());
    }

    public void println (String string) throws IOException {
        out.write(string);
        out.newLine();
    }

    public void print (String string) throws IOException {
        out.write(string);
    }

    public void flush () throws IOException {
        out.flush();
    }

    public void  close () throws IOException {
        in.close();
        out.close();
    }
}
