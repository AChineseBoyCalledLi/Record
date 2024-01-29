package 杭电;

import java.util.Scanner;

public class muniudegushi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n != 0)
                solve(n);
        }
    }

    static void solve(int n) {
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (i > 4) {
                dp[i][0] = dp[i - 1][0] + (dp[i - 2][1] - dp[i - 3][1]);
                dp[i][1] = dp[i][0] + dp[i - 1][1] - (dp[i - 2][1] - dp[i - 3][1]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i][0] + dp[i - 1][1];
            }
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
