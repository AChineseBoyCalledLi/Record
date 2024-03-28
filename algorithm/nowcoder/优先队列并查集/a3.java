package nowcoder.优先队列并查集;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

import javax.print.attribute.standard.PrintQuality;

public class a3 {
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
        int n = nextInt(), m = nextInt(), k = nextInt();
        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < n; i++) {
            Q.add(nextInt());
            if (Q.size() > k)
                Q.poll();
        }
        while (m-- > 0) {
            if (nextInt() == 2) {
                if (Q.size() < k)
                    pw.println(-1);
                else
                    pw.println(Q.peek());
            } else {
                Q.add(nextInt());
                if (Q.size() > k)
                    Q.poll();
            }
        }
        pw.flush();
    }
}
