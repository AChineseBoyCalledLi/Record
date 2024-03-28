package 动态规划1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a1 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
    }

    static void solve() throws Exception {
        int n = nextInt();
        if (n < 3) {
            pw.println(n);
        } else {
            long a1 = 1;
            long a2 = 2;
            long t = a1 + a2;
            for (int i = 2; i < n; i++) {
                t = a1 + a2;
                a1 = a2;
                a2 = t;
            }
            pw.println(t);
        }
        pw.flush();
    }
}
