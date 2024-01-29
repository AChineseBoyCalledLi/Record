package cf;

import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] count = new int[n + 2];
            long sum = 0;
            int mex = 0;

            for (int i = 0; i < n; i++) {
                mex = 0; // Reset mex for new subarray
                Arrays.fill(count, 0); // Reset count for new subarray
                for (int j = i; j < n; j++) {
                    // Update count and mex
                    if (arr[j] <= n) {
                        count[arr[j]]++;
                        while (count[mex] > 0) {
                            mex++;
                        }
                    }
                    sum += mex; // Add current mex to sum
                }
            }

            System.out.println(sum);
        }
        sc.close();
    }
}
