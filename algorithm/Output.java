import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Output {
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    void println() {
        pw.println(null);
    }
}
