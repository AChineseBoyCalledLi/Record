import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Input {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer st = new StreamTokenizer(bf);

    int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    long nextLong() throws Exception {
        st.nextToken();
        return (long) st.nval;
    }

    String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

    String nextLine() throws Exception {
        return bf.readLine();
    }
}
