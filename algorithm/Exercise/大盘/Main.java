import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    static int N;
    static long[] cha;
    static long[] he;

    public static void main(String[] args) throws Exception {
        N = nextInt();
        int m = nextInt();
        cha = new long[N + 1];
        he = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            insert(cha, i, i, nextInt());
            update(he, i, i * (sum(cha, i) - sum(cha, i - 1)));
        }
        while (m-- > 0) {
            String id = next();
            if (id.equals("Q")) {
                int l = nextInt();
                int r = nextInt();
                long ans = (r + 1) * sum(cha, r) - l * sum(cha, l - 1) - sum(he, r) + sum(he, l - 1);
                pw.println(ans);
            } else {
                int l = nextInt();
                int r = nextInt();
                int x = nextInt();
                insert(cha, l, r, x);
                update(he, l, l * x);
                update(he, r + 1, (r + 1) * -x);
            }
        }
        pw.flush();
    }

    static int lowbit(int x) {
        return x & (-x);
    }

    static void insert(long[] arr, int l, int r, long x) {
        update(arr, l, x);
        update(arr, r + 1, -x);
    }

    static void update(long[] arr, int idx, long x) {
        while (idx <= N) {
            arr[idx] += x;
            idx += lowbit(idx);
        }
    }

    static long sum(long[] arr, int idx) {
        long ret = 0;
        while (idx > 0) {
            ret += arr[idx];
            idx -= lowbit(idx);
        }
        return ret;
    }
}
