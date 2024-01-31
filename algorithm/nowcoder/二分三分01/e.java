package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class e {
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
    static ArrayList<Integer> ans;

    static int N, D;

    public static void main(String[] args) {
        N = nextInt();
        D = nextInt();
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        long l = 0;
        long r = 50000000000L;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            if (check(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        check(r);
        pw.write(r + "\n");
        for (int x : ans) {
            pw.write(x + 1 + "\n");
        }
        pw.flush();
    }

    static boolean check(long x) {
        long sum = 0;
        ans = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < D; i++) {
            sum = sum >> 1;
            while (idx < arr.length && sum < x) {
                sum += arr[idx++];
                ans.add(i);
            }
            if (sum < x)
                return false;
        }
        while (idx < arr.length) {
            idx++;
            ans.add(D - 1);
        }
        return true;
    }
}
