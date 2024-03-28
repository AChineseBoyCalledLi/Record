package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class i {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    static int[] arr = new int[10010];

    public static void main(String[] args) {
        int n = nextInt();

        PriorityQueue<Integer> Q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Q.add(nextInt());
        }

        int ans = 0;
w
        while (Q.size() > 1) {
            int t = Q.poll();
            t += Q.poll();
            Q.add(t);
            ans += t;
        }

        pw.println(ans);
        pw.flush();
        pw.close();
    }
}
