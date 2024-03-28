package 动态规划1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a3 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static long nextInt() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    public static void main(String[] args) throws Exception {
        pw.println(nextInt());
        pw.flush();
    }
}
