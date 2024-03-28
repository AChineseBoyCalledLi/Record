package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Stack;

public class n {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nextInt();
        }
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty())
                ans[i] = s.peek() + 1;
            else
                ans[i] = 0;
            s.add(i);
        }
        for (int i = 0; i < ans.length; i++) {
            pw.println(ans[i]);
        }
        pw.flush();
    }
}
