package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class m {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int len = nextInt();
        Deque<Pair> D = new LinkedList<>();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            while (!D.isEmpty() && val[i] <= D.peekLast().val) {
                D.pollLast();
            }
            if (!D.isEmpty() && D.peekFirst().idx + len - 1 < i) {
                D.pollFirst();
            }
            D.add(new Pair(i, val[i]));
            if (i >= len - 1) {
                pw.write(D.peekFirst().val + " ");
            }
        }
        pw.println();
        D.clear();
        for (int i = 0; i < n; i++) {
            while (!D.isEmpty() && val[i] >= D.peekLast().val) {
                D.pollLast();
            }
            if (!D.isEmpty() && D.peekFirst().idx + len - 1 < i) {
                D.pollFirst();
            }
            D.add(new Pair(i, val[i]));
            if (i >= len - 1) {
                pw.write(D.peekFirst().val + " ");
            }
        }
        pw.flush();
    }

    static class Pair {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
