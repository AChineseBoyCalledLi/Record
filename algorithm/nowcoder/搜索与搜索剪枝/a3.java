import java.io.*;
import java.util.*;

public class a3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static ArrayList<Integer> aQ = new ArrayList<>();
    static ArrayList<Integer> aS = new ArrayList<>();
    static boolean[][] isVisitedQ = new boolean[4][100];
    static boolean[][] isVisitedS = new boolean[4][100];
    static char[][] areaQ = new char[4][];
    static char[][] areaS = new char[4][];
    static int sum;
    static int m;

    public static void main(String[] args) throws Exception {
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < 4; i++) {
            areaS[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 4; i++) {
            areaQ[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisitedQ[i][j] && areaQ[i][j] == '*') {
                    sum = 0;
                    dfsQ(i, j);
                    aQ.add(sum);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisitedS[i][j] && areaS[i][j] == '*') {
                    sum = 0;
                    dfsS(i, j);
                    aS.add(sum);
                }
            }
        }
        aS.sort(null);
        aQ.sort((x, y) -> (y - x));
        while (!aQ.isEmpty() && !aS.isEmpty()) {
            aS.remove(aS.size() - 1);
            if (!aS.isEmpty())
                aQ.remove(aQ.size() - 1);
        }
        if (aS.isEmpty()) {
            int ans = 0;
            while (!aQ.isEmpty()) {
                ans += aQ.remove(aQ.size() - 1);
            }
            pw.println(ans);

        } else {
            pw.println(-1);
        }
        pw.flush();
    }

    static void dfsQ(int x, int y) {
        if (x < 0 || y < 0 || x == 4 || y == m || areaQ[x][y] == '.' || isVisitedQ[x][y])
            return;
        sum++;
        isVisitedQ[x][y] = true;
        dfsQ(x - 1, y);
        dfsQ(x + 1, y);
        dfsQ(x, y + 1);
        dfsQ(x, y - 1);
        dfsQ(x + 1, y + 1);
        dfsQ(x + 1, y - 1);
        dfsQ(x - 1, y + 1);
        dfsQ(x - 1, y - 1);
    }

    static void dfsS(int x, int y) {
        if (x < 0 || y < 0 || x == 4 || y == m || areaS[x][y] == '.' || isVisitedS[x][y])
            return;
        sum++;
        isVisitedS[x][y] = true;
        dfsS(x - 1, y);
        dfsS(x + 1, y);
        dfsS(x, y + 1);
        dfsS(x, y - 1);
        dfsS(x + 1, y + 1);
        dfsS(x + 1, y - 1);
        dfsS(x - 1, y + 1);
        dfsS(x - 1, y - 1);
    }
}
