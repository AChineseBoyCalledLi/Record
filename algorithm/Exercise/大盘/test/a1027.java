package Exercise.大盘.test;

import java.util.Scanner;

public class a1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time = sc.nextInt() * 60;
        int[] activity = new int[n];
        int[] happy = new int[n];
        int[][] dp = new int[n + 1][time + 1];
        for (int i = 0; i < n; i++) {
            activity[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            happy[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= time; j++) {
                if (j - activity[i - 1] >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - activity[i - 1]] + happy[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[n][time]);
        sc.close();
    }
}
