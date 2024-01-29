package newcoder.递归分治;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a3 {
    static Input ip = new Input();

    public static void main(String[] args) throws Exception {
        int m = ip.nextInt();
        int n = ip.nextInt();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        while (m != n) {
            if (m > n)
                m = m - n;
            if (m < n)
                n = n - m;
        }
        pw.println(m);
        pw.flush();
    }

    static class Input {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(bf);

        int nextInt() throws Exception {
            st.nextToken();
            return (int) st.nval;
        }

        long nextLong() throws Exception {
            st.nextToken();
            return (long) st.nval;
        }

        String next() throws Exception {
            st.nextToken();
            return st.sval;
        }

        String nextLine() throws Exception {
            return bf.readLine();
        }
    }
}
