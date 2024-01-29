package 杂七杂八;

import java.util.Scanner;

public class OnlineJudge10382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] dp = new int[n + 1][n + 1];
            dp[1][0] = 1;
            dp[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= k - 1; j++) {
                    dp[i][0] += dp[i - 1][j];
                }
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
            int ans = 0;
            for (int i = k; i <= n; i++) {

                ans += dp[i][k] * Math.pow(2, n - i);

            }
            System.out.println(ans);
        }
    }
}
