import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class j {
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

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    static long Big = 1000000009;

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        long L = nextLong();
        long R = nextLong();
        if (a == 1) {
            L = Integer.bitCount(c)
        }
        long sum1 = cur(R);
        long sum2 = cur(L);
        pw.println(sum1 - sum2 + 1);
        pw.flush();
    }

    static long cur(long x) {
        if (x == 0)
            return 0;
        int o = 0, z = 0;
        long tmp = x;
        long idx = 1;
        while (tmp > 0) {
            if ((tmp & 1) == 0) {
                z++;
            } else {
                o++;
            }
            tmp = tmp >> 1;
        }
        tmp = x;
        int mid = ((o + z) >> 1) + 1;
        int cnt = 0;
        for (int i = o + z - 1; i >= 0; i--) {
            if (((tmp >> i) & 1) == 1 && cnt < mid) {
                cnt++;
                idx = i + 1;// 正好成为好数的1在第几位上
            }
        }
        long sum = 0;
        if ((o + z) % 2 == 0) {
            sum += combination(o + z - 1, (o + z) >> 1);
        } else {
            sum += combination(o + z - 1, (o + z + 1) >> 1);
        }
        sum %= Big;
        if (o > z) {
            sum += fac(idx - 1);
        } else {
            sum += combination(idx - 1, z - o + 1);
        }
        sum %= Big;
        return sum;
    }

    static long combination(long n, long m) {
        if (n < m)
            return 0;
        return (fac(n) / (fac(n - m) * fac(m))) % Big;
    }

    static long fac(long n) {
        long ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i % Big;
            ret %= Big;
        }
        return ret;
    }
}
