package nowcoder.递归分治;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a6_1 {
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
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        pw.println(mergesort(arr, 0, n - 1));
        pw.flush();
    }

    static long mergesort(int[] a, int p, int r) {
        if (p < r) {
            int mid = (p + r) >> 1;
            long ret = 0;
            ret += mergesort(a, p, mid);
            ret += mergesort(a, mid + 1, r);
            ret += merge(a, p, mid, r);
            return ret;
        }
        return 0;
    }

    static long merge(int[] a, int p, int q, int r) {
        long ans = 0;
        int size1 = q - p + 1;
        int size2 = r - q;
        int[] aux1 = new int[size1 + 1];
        int[] aux2 = new int[size2 + 1];
        for (int i = 0; i < size1; i++) {
            aux1[i] = a[p + i];
        }
        aux1[size1] = Integer.MAX_VALUE;
        for (int i = 0; i < size2; i++) {
            aux2[i] = a[q + 1 + i];
        }
        aux2[size2] = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;
        for (int i = p; i <= r; i++) {
            if (aux1[idx1] <= aux2[idx2]) {
                a[i] = aux1[idx1++];
            } else {
                a[i] = aux2[idx2++];
                ans += size1 - idx1;
            }
        }
        return ans;
    }
}
