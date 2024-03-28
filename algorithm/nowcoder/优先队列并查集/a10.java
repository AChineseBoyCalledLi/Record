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

public class a10 {
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

    public static void main(String[] args) throws IOException {
        while (st.nextToken() != -1) {
            int n = (int) st.nval;
            int m = nextInt();
            PriorityQueue<Line> Q = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                Q.offer(new Line(nextInt(), nextInt(), nextInt()));
            }
            boolean[] isVisited = new boolean[n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                Line t = Q.poll();
                int num = 0;
                for (int j = t.l; j <= t.r; j++) {
                    if (!isVisited[j - 1] && num < t.v) {
                        isVisited[j - 1] = true;
                        num++;
                    }
                }
                ans += num;
            }
            pw.println(ans);
            pw.flush();
        }
    }

    static class Line implements Comparable<Line> {
        int l, r, v;

        public Line(int l, int r, int v) {
            this.l = l;
            this.r = r;
            this.v = v;
        }

        public int compareTo(Line o) {
            int ret = 0;
            ret = this.r - o.r;
            if (ret != 0)
                return ret;
            ret = this.l - this.l;
            return ret;
        }
    }
}
