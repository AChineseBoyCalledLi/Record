package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a {
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

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        n = nextInt();
        int[] stack = new int[n];
        arr = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int[] max = new int[n + 1];
        max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            stack[++top] = arr[i];
            while (top >= 0 && stack[top] > max[i + 1]) {
                pw.write(stack[top--] + " ");
            }
        }
        pw.flush();
    }
}
