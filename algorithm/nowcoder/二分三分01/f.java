package nowcoder.二分三分01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class f {
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

    static int n, k;
    static int[] arr;

    public static void main(String[] args) {
        n = nextInt();
        k = nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        int l = 1;
        int r = 1000000000;
        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if (check(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        // 如果check，增大看看，如果不，缩小。
        pw.println(r);
        pw.flush();
    }

    static boolean check(int x) {
        int cnt = 0;
        int[] newArr = arr.clone();
        for (int i = 0; i < newArr.length; i++) {
            while (newArr[i] >= x) {
                newArr[i] -= x;
                cnt++;
            }
        }
        return cnt >= k;
    }
}
