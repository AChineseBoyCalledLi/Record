package nowcoder.优先队列并查集;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class a2 {
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
        int N = nextInt();
        for (int i = 0; i < N; i++) {
            solve();
            if (i != N - 1) {
                pw.write("\n");
            }
        }
        pw.flush();
    }

    static void solve() {
        int num = nextInt();
        int n = nextInt();
        pw.println(num + " " + (n + 1) / 2);
        PriorityQueue<Integer> Qsma = new PriorityQueue<>();
        PriorityQueue<Integer> Qbig = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        int mid = 0;
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (Qsma.size() == Qbig.size()) {
                if (Qsma.isEmpty()) {
                    Qsma.add(t);
                    mid = t;
                } else if (Qbig.peek() >= t) {
                    Qbig.add(t);
                    mid = Qbig.peek();
                } else {
                    Qsma.add(t);
                    mid = Qsma.peek();
                }

            } else if (Qsma.size() > Qbig.size()) {
                if (Qsma.peek() < t) {
                    Qbig.add(Qsma.poll());
                    Qsma.add(t);
                } else {
                    Qbig.add(t);
                }
            } else {
                if (Qbig.peek() > t) {
                    Qsma.add(Qbig.poll());
                    Qbig.add(t);
                } else {
                    Qsma.add(t);
                }
            }
            if (i % 2 == 0) {
                pw.write(mid + " ");
                if ((i / 2 + 1) % 10 == 0 && i < n - 1) {
                    pw.println();
                }
            }
        }
    }

}
