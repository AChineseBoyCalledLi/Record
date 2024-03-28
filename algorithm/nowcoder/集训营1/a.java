import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class a {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            solve();
        }
        bf.close();
    }

    static void solve() throws NumberFormatException, IOException {
        int t = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        Boolean f1 = false;
        Boolean f2 = false;
        for (int i = 0; i < t; i++) {
            if (str.charAt(i) == 'D' && !f1) {
                int j = i + 1;
                while (j < str.length()) {
                    if (str.charAt(j) == 'F') {
                        while (j < str.length()) {
                            if (str.charAt(j) == 'S') {
                                f1 = true;
                                break;
                            }
                            j++;
                        }
                        break;
                    }
                    j++;
                }
            } else if (str.charAt(i) == 'd' && !f2) {
                int j = i + 1;
                while (j < str.length()) {
                    if (str.charAt(j) == 'f') {
                        while (j < str.length()) {
                            if (str.charAt(j) == 's') {
                                f2 = true;
                                break;
                            }
                            j++;
                        }
                        break;
                    }
                    j++;
                }
            }

        }
        int t1 = f1 ? 1 : 0;
        int t2 = f2 ? 1 : 0;
        pw.println(t1 + " " + t2);
        pw.flush();
    }
}
