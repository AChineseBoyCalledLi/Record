package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class c {
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
        int L = nextInt();
        int N = nextInt();
        int M = nextInt();
        int[] dist = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            dist[i] = nextInt();
        }
        dist[N + 1] = L;
        int l = 0;
        int r = L;
        while (l < r) {
            int mid = r + ((l - r) >> 1);
            if (check(dist, N, mid, M))
                l = mid + 1;
            else
                r = mid - 1;
        }
        pw.println(l);
        pw.flush();
    }

    static boolean check(int[] arr, int N, int mid, int M) {
        int count = 0;
        int last = 0;
        for (int i = 1; i <= N + 1; i++) {
            if (arr[i] - last <= mid)
                count++;
            else
                last = arr[i];
        }
        return count <= M;
    }
}
