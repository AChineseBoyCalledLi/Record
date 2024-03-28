import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class a1 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        dfs(1);
    }

    static boolean[] isvisited = new boolean[9];
    static int[] des = new int[9];

    static void dfs(int pos) {
        if (pos == 9) {
            for (int i = 1; i < des.length; i++) {
                pw.write(des[i] + " ");
            }
            pw.write("\n");
            pw.flush();
        } else {
            for (int i = 1; i < isvisited.length; i++) {
                if (!isvisited[i]) {
                    isvisited[i] = true;
                    des[pos] = i;
                    dfs(pos + 1);
                    isvisited[i] = false;
                }
            }
        }
    }
}
