package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class g {
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

    static int n, m;

    static int[] arr;

    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int l = 0;
        int r = 1000000000;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (check(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        // 如果check说明满足了，可以试试更多套，反之减少.
        pw.println(r);
        pw.flush();
    }

    static boolean check(int x) {
        int aux = m > x ? x : m;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < x) {
                aux -= x - arr[i];
            }
            if (aux < 0) {
                return false;
            }
        }
        return true;
    }
}
