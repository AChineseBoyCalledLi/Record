package nowcoder.递归分治;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a6 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int[] arr = new int[100001];
    static int idx = 1;

    static void init() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        long sum = 0;
        init();
        for (int i = 0; i < n; i++) {
            int num = nextInt();
            int j = findPos(num);
            sum += j;
            idx++;
        }
        pw.println(sum);
        pw.flush();
    }

    static int findPos(int n) {
        int i = idx - 1;
        arr[idx] = n;
        while (i >= 0 && arr[i] <= n) {
            arr[i + 1] = arr[i--];
        }
        if (i != idx - 1) {
            arr[i + 1] = n;
        }
        return i + 1;
    }

    static void swap(int i, int j) {
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
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
