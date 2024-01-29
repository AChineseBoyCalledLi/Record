package 杭电;

import java.util.Scanner;

public class shuta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[N][N];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[N - 1][i] > max) {
                max = dp[N - 1][i];
            }
        }
        System.out.println(max);
    }
}
