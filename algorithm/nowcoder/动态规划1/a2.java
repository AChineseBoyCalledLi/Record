package 动态规划1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class a2 {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
    }

    static int mod = 1000000007;

    static void solve() throws IOException {
        int n = nextInt();
        long[][][] dp = new long[3][2][n + 1];
        dp[0][0][1] = 1;
        dp[1][0][1] = 1;
        dp[2][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[0][0][i] = (dp[1][0][i - 1] + dp[2][0][i - 1] + dp[1][1][i - 1] + dp[2][1][i - 1]) % mod;
            dp[1][0][i] = (dp[0][0][i - 1] + dp[2][0][i - 1] + dp[0][1][i - 1] + dp[2][1][i - 1]) % mod;
            dp[2][0][i] = (dp[1][0][i - 1] + dp[0][0][i - 1] + dp[1][1][i - 1] + dp[0][1][i - 1]) % mod;
            dp[0][1][i] = dp[0][0][i - 1];
            dp[1][1][i] = dp[1][0][i - 1];
            dp[2][1][i] = dp[2][0][i - 1];
        }
        long ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                ans += dp[i][j][n];
                ans %= mod;
            }
        }
        pw.println(ans);
        pw.flush();
    }
}
