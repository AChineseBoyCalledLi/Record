import java.io.*;
import java.util.*;

public class Main {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    static int w;
    static int h;

    public static void main(String[] args) throws Exception {
        w = nextInt();
        h = nextInt();
        int[][] ps = new int[w + 1][1050];
        int time = 0;
        while (st.nextToken() != -1) {
            Pie t = new Pie((int) st.nval, nextInt(), nextInt(), nextInt());
            ps[t.pos][t.avl] += t.scr;
            time = Math.max(time, t.avl);
        }
        int[][] dp = new int[w][time + 1];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= time; j++) {
                dp[i][j] = -0x3f3f3f3f;
            }
        }
        dp[w / 2][0] = 0;
        int ans = -0x3f3f3f3f;
        for (int j = 1; j <= time; j++) {
            for (int i = 0; i < w; i++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + ps[i + 1][j]);
                if (i > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + ps[i + 1][j]);
                if (i > 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + ps[i + 1][j]);
                if (i < w - 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + ps[i + 1][j]);
                if (i < w - 2)
                    dp[i][j] = Math.max(dp[i][j], dp[i + 2][j - 1] + ps[i + 1][j]);
                // if(w==9&&i==0&&j==4)pw.println(dp[i][j]+" "+dp[i+2][j-1]);
            }
        }
        int pre = 0;
        for (int i = 0; i < w; i++) {
            if (ans < dp[i][time]) {
                ans = dp[i][time];
                pre = i;
            }
        }
        pw.println(ans);
        ans -= ps[pre + 1][time];
        int[] idx = new int[time];
        for (int i = time - 1; i > 0; i--) {
            for (int j = 0; j < w; j++) {
                if (dp[j][i] == ans) {
                    if (pre > j && pre - j > 2 || pre < j && pre - j < -2)
                        continue;
                    idx[i] = pre - j;
                    ans -= ps[j + 1][i];
                    pre = j;
                    break;
                }
            }
        }
        if (time != 0) {
            idx[0] = pre - w / 2;
        }
        for (int i = 0; i < time; i++) {
            pw.println(idx[i]);
        }

        pw.flush();
    }

    static class Pie {
        int avl;
        int pos;
        int scr;

        public Pie(int time, int pos, int spd, int scr) {
            this.avl = time + (h - 1) / spd;
            this.pos = pos;
            this.scr = scr;
        }

    }
}