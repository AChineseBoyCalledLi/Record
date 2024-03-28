package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class e {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String str = bf.readLine();
            if (str == null || str == "\n" || str == "")
                break;
            char[] arr = str.toCharArray();
            int top = 0;
            char[] stack = new char[105];
            stack[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                stack[++top] = arr[i];
                while (top > 0 && stack[top] == stack[top - 1]) {
                    if (stack[top] == 'o') {
                        stack[--top] = 'O';
                    } else {
                        top -= 2;
                    }
                }
            }
            for (int i = 0; i <= top; i++) {
                pw.write(stack[i]);
            }
            pw.println();
            pw.flush();
        }
    }
}
