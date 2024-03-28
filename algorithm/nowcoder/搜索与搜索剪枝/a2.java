import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class a2 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        while (br.ready()) {
            flag = false;
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[2]);
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'S') {
                        x = i;
                        y = j;
                    }
                }
            }
            dfs(x, y);
            if (flag) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }
        pw.flush();
    }

    static int m, n;
    static char[][] map = new char[502][502];
    static boolean flag = false;

    static void dfs(int x, int y) {
        if (x == n || y == m || x < 0 || y < 0 || map[x][y] == '#') {
            return;
        }
        if (map[x][y] == 'E') {
            flag = true;
            return;
        }
        map[x][y] = '#';
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
