package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class d {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static StreamTokenizer st = new StreamTokenizer(bf);

    static int n;

    static int[] aux = new int[1010];

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    public static void main(String[] args) {
        n = nextInt();
        int[] num = new int[1010];
        int top = 0;
        while (n != 0) {
            aux[1] = nextInt();
            while (aux[1] != 0) {
                top = 0;
                for (int i = 2; i <= n; i++) {
                    aux[i] = nextInt();
                }
                int cnt = 1;
                for (int i = 1; i <= n; i++) {
                    num[++top] = i;
                    while (top > 0 && num[top] == aux[cnt]) {
                        top--;
                        cnt++;
                    }
                }
                if (top == 0) {
                    pw.println("Yes");
                } else {
                    pw.println("No");
                }
                aux[1] = nextInt();
            }
            pw.println();
            n = nextInt();
        }
        pw.flush();
    }
}
