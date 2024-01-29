package Exercise.大盘.test;

import java.util.Scanner;

public class a1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long[][] dp = new long[100001][2];
        pre(dp);
        for (int i = 0; i < size; i++) {
            int day = sc.nextInt();
            System.out.println((dp[day][0] + dp[day][1]) % mod);
        }
        sc.close();

    }

    static long mod = 1000000007;

    static void pre(long[][] dp) {
        dp[1][0] = 3;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] * 2 % mod + dp[i - 1][1] * 2 % mod;
            dp[i][1] = dp[i - 1][0];
        }
    }

}
