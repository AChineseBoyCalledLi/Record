package nowcoder.二分三分01;

import java.io.*;

public class a {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int[] query;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        query = new int[n + 1];
        int Q = 0;
        for (int i = 1; i <= n; i++) {
            Q += nextInt();
            query[i] = Q;
        }
        for (int i = 0; i < m; i++) {
            int num = nextInt();
            pw.write(q(num, 0, query.length) + 1 + "\n");
        }
        pw.flush();
    }

    static int q(int n, int start, int end) {
        int mid = start + end >> 1;
        if (query[mid] == n) {
            return mid;
        } else if (query[mid] < n) {
            if (mid + 1 < query.length && query[mid + 1] > n) {
                return mid;
            } else {
                return q(n, mid, end);
            }
        } else {
            return q(n, start, mid);
        }
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
