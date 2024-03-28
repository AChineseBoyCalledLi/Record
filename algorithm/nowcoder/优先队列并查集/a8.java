package nowcoder.优先队列并查集;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.PriorityQueue;

public class a8 {
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
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        long aux = 0;
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            aux += t;
            Q.offer(t);
        }
        long ans = 0;
        while (Q.size() > 1) {
            ans += aux;
            aux -= Q.poll();
        }
        pw.print(ans);
        pw.flush();
    }
}
