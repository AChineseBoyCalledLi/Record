package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class f {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() {
        return (int) st.nval;
    }

    public static void main(String[] args) throws IOException {
        while (st.nextToken() != -1) {
            int N = nextInt();
            st.nextToken();
            int M = nextInt();
            st.nextToken();
            int Q = nextInt();
            int max = 50010;
            boolean[] boo = new boolean[max];
            int[] a = new int[max];
            int[] nextI = new int[max];
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < Q; i++) {
                boo[i] = false;
                st.nextToken();
                a[i] = nextInt();
            }
            for (int i = Q - 1; i >= 0; i--) {
                if (map.get(a[i]) == null) {
                    nextI[i] = max - 9;
                } else {
                    nextI[i] = map.get(a[i]);
                }
                map.put(a[i], i);
            }
            int size = 0;
            int ans = 0;
            for (int i = 0; i < Q; i++) {
                if (!boo[i]) {
                    ans++;
                    if (size < N) {
                        q.offer(nextI[i]);
                        boo[nextI[i]] = true;
                        size++;
                    } else {
                        boo[q.poll()] = false;
                        q.offer(nextI[i]);
                        boo[nextI[i]] = true;
                    }
                } else {
                    q.offer(nextI[i]);
                    boo[nextI[i]] = true;
                }
            }
            pw.println(ans);
            pw.flush();
        }
    }
}
