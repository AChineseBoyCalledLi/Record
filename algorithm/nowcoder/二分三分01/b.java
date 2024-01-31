package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class b {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        pw.flush();
    }

    static void solve() {
        int l = nextInt();
        int r = nextInt();
        int L = (int) Math.ceil(Math.sqrt(l));
        int R = (int) Math.floor(Math.sqrt(r));
        pw.write(R - L + 1 + "\n");
    }

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }
}
