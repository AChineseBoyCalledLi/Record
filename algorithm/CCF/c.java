import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class c {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static StreamTokenizer st = new StreamTokenizer(bf);

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    static ArrayList<Integer> a;
    static int n;
    static int x;

    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        int dif = (m - n) / n;
        a = new ArrayList<>();
        x = dif;
    }

    static void find(int y, int pos) {
        if (x == 0) {
            return;
        }
        x -= y / ((n + 1) * (pos + 1));
        find(y, pos++);
    }
}
