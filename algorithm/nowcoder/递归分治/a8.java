package nowcoder.递归分治;

import java.io.*;

public class a8 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] arr;
    static long sum = 0;

    public static void main(String[] args) {
        int n = nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        int m = nextInt();
        sum += mergesort(arr, 0, n - 1);
        for (int i = 0; i < m; i++) {
            solve();
        }
        pw.flush();
    }

    static void solve() {
        int l = nextInt() - 1;
        int r = nextInt() - 1;
        sum += ni(r - l + 1);
        if (sum % 2 == 0)
            pw.write("like\n");
        else
            pw.write("dislike\n");
    }

    static long mergesort(int[] a, int p, int r) {
        if (p >= r)
            return 0;
        int mid = p + r >> 1;
        long ret = 0;
        ret += mergesort(a, p, mid);
        ret += mergesort(a, mid + 1, r);
        ret += merge(a, p, mid, r);
        return ret;
    }

    static int ni(int n) {
        return (n) * (n - 1) >> 1;
    }

    static long merge(int[] a, int p, int q, int r) {
        long ans = 0;
        int size1 = q - p + 1;
        int size2 = r - q;
        int[] left = new int[size1 + 1];
        int[] right = new int[size2 + 1];
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = a[i + p];
        }
        for (int i = 0; i < right.length - 1; i++) {
            right[i] = a[i + 1 + q];
        }
        left[size1] = Integer.MAX_VALUE;
        right[size2] = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;
        for (int i = p; i <= r; i++) {
            if (left[idx1] <= right[idx2]) {
                a[i] = left[idx1++];
            } else {
                a[i] = right[idx2++];
                ans += size1 - idx1;
            }
        }
        return ans;
    }

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }
}
