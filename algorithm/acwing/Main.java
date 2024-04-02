import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    static long nextLong() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    public static void main(String[] args) throws Exception {
        double cos = 1 / (4 * Math.sqrt(2)) * Math.sqrt(Math.sqrt(61) + 13);
        double sin = 1 / (4 * Math.sqrt(2)) * Math.sqrt(-Math.sqrt(61) + 19);
        double vb = Math.sqrt(3) / (4 * Math.sqrt(3) * cos + 4 * sin);
        double va = 2 * sin / (Math.sqrt(3) * cos + sin);
        pw.println(Math.asin(sin));
        pw.println(va);
        pw.println(vb);
        pw.flush();
    }
}