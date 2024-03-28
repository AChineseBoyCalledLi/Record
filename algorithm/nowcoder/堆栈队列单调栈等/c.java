package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;

public class c {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String str = bf.readLine();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a')
                s.push('a');
            else {
                if (s.isEmpty()) {
                    pw.write("Bad");
                    pw.flush();
                    return;
                } else {
                    s.pop();
                }
            }
        }
        if (s.isEmpty()) {
            pw.write("Good");
        } else {
            pw.write("Bad");
        }
        pw.flush();
    }
}
