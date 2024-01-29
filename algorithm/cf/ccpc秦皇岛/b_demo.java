package cf.ccpc秦皇岛;

import java.util.Scanner;

public class b_demo {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][][][] dp = new int[n + 1][m + 1][k + 1][2];
        dp[0][0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int l = 0; l <= k; l++) {
                    for (int x = 0; x < 2; x++) {
                        // 输掉当前游戏
                        dp[i][j][0][x] = (dp[i][j][0][x] + dp[i - 1][j][l][x]) % MOD;

                        // 赢得当前游戏
                        if (j > 0) {
                            if (l < k) {
                                // 继续当前的连胜
                                dp[i][j][l + 1][x] = (dp[i][j][l + 1][x] + dp[i - 1][j - 1][l][x]) % MOD;
                            } else if (x == 0) {
                                // 达到k连胜，且之前没有达到过k连胜
                                dp[i][j][l][1] = (dp[i][j][l][1] + dp[i - 1][j - 1][l][x]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int l = 0; l <= k; l++) {
            result = (result + dp[n][m][l][1]) % MOD;
        }
        System.out.println(result);
    }
}
