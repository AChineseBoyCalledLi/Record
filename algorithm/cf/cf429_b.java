package cf;

import java.util.Scanner;

public class cf429_b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] mat = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int x1 = 1, y1 = 1, x2 = n, y2 = 1;
        int[][] dp = new int[n + 2][m + 2];
        dp[1][1] = mat[1][1];
        for (int i = 1; i < m + n; i++) {
            dp[i][]
        }
    }
}
