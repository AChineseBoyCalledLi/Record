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

public class a4 {
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
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        Arrays.sort(pairs);
        PriorityQueue<Pair> Q = new PriorityQueue<>((o1, o2) -> (o1.v - o2.v));
        long sum = 0;
        long max = 0;
        for (int i = 0; i < pairs.length; i++) {
            Q.add(pairs[i]);
            sum += pairs[i].v;
            while (Q.size() > pairs[i].s) {
                sum -= Q.poll().v;
            }
            max = max > sum ? max : sum;
        }
        pw.println(max);
        pw.flush();
    }

    static class Pair implements Comparable<Pair> {
        int s;
        int v;

        public Pair(int v, int s) {
            this.v = v;
            this.s = s;
        }

        public int compareTo(Pair o) {
            return o.s - this.s;
        }
    }
}
