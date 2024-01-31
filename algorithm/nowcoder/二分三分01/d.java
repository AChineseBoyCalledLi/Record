package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class d {
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

    static int[] arr;
    static int N;

    public static void main(String[] args) {
        N = nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = nextInt();
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        pw.println(N - r);
        pw.flush();
    }

    static boolean check(int x) {
        int[] aux = arr.clone();
        Arrays.sort(aux, 1, x);
        int tmp = x;
        for (int i = 1; i < x; i++) {
            if (N - aux[i] < tmp)
                return false;
            tmp--;
        }
        return true;
    }
}
