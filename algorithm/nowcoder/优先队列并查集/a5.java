package nowcoder.优先队列并查集;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class a5 {
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
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(nextInt(), nextInt());
        }
        Arrays.sort(p);
        PriorityQueue<Integer> Q = new PriorityQueue<>((x, y) -> (y - x));
        int time = 0;
        for (int i = 0; i < p.length; i++) {
            time += p[i].t1;
            Q.add(p[i].t1);
            if (time > p[i].t2) {
                time -= Q.poll();
            }
        }
        pw.print(Q.size());
        pw.flush();

    }

    static class Pair implements Comparable<Pair> {
        int t1, t2;

        public Pair(int t1, int t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public int compareTo(Pair o) {
            return this.t2 - o.t2;
        }
    }
}
