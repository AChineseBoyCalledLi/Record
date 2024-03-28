import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class b {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static StreamTokenizer st = new StreamTokenizer(bf);

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static long nextLong() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (long) st.nval;
    }

    public static void main(String[] args) {
        long n = nextLong();
        long m = nextLong();
        if (n == m) {
            pw.write(n + " " + m);
            pw.flush();
            return;
        }
        long small = Math.min(n, m);
        long big = Math.max(n, m);
        boolean flag = true;
        flag = n == small;
        n = small;
        m = big;
        P B = new P(n, n);
        long dif = m - n;
        if (dif == n) {
            small = n;
            big = n;
        } else if (dif > n) {
            P C = new P(0, B.y + n);

            long dis = m - C.y;
            if (dis <= n) {
                small = dis;
                big = m;
            } else {
                small = n;
                big = 3 * n;
            }

        }
        if (dif < n) {
            small = 0;
            big = dif << 1;
        }

        if (!flag) {
            pw.write(big + " " + small);
        } else
            pw.write(small + " " + big);
        pw.flush();
    }

    static class P {
        long x;
        long y;

        public P(long x, long y) {
            this.x = x;
            this.y = y;
        }

    }
}
