package nowcoder.优先队列并查集;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class a6 {
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
        int m = nextInt();
        int max = 100010;
        int[] a = new int[max];
        int[] nexti = new int[max];
        boolean[] boo = new boolean[max];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            boo[i] = false;
            a[i] = nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            if (map.get(a[i]) == null) {
                nexti[i] = max - 9;
            } else {
                nexti[i] = map.get(a[i]);
            }
            map.put(a[i], i);
        }
        int num = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (!boo[i]) {
                ans++;
                if (num < m) {
                    Q.offer(nexti[i]);
                    boo[nexti[i]] = true;
                    num++;
                } else {
                    boo[Q.poll()] = false;
                    Q.offer(nexti[i]);
                    boo[nexti[i]] = true;
                }
            } else {
                Q.offer(nexti[i]);
                boo[nexti[i]] = true;
            }
        }
        pw.println(ans);
        pw.flush();
    }
}
