package 杭电;

import java.util.Scanner;

public class Mex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0)
                return;
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] count = new int[n + 2];
            long sum = 0;
            int dp[] = new int[n];

            for (int i = 0; i < n; i++) {
                count = new int[n + 2];
                for (int j = i; j < n; j++) {
                    if (arr[j] > n)
                        count[n]++;
                    else
                        count[arr[j]]++;
                }
                if (count[0] == 0)
                    break;
                dp[n - 1] = 0;
                while (count[dp[n - 1]] > 0)
                    dp[n - 1]++;
                System.out.println("i=" + i + ",j=" + (n - 1) + ",mex=" + dp[n - 1]);
                sum += dp[n - 1];
                for (int j = n - 2; j >= i; j--) {
                    if (arr[j + 1] > n) {
                        dp[j] = dp[j + 1];
                        count[n]--;
                    } else if (--count[arr[j + 1]] > 0 || arr[j + 1] > dp[j + 1]) {
                        dp[j] = dp[j + 1];
                    } else {
                        dp[j] = arr[j + 1];
                    }
                    System.out.println("i=" + i + ",j=" + j + ",mex=" + dp[j]);
                    sum += dp[j];

                }
            }

            System.out.println(sum);
        }
    }
}
