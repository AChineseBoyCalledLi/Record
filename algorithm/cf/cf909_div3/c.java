package cf.cf909_div3;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                max = arr[i];
                ans = Math.max(max, ans);
                int j = i;
                if (j + 1 < arr.length && arr[j] + arr[j + 1] > 0)
                    while (j + 1 < arr.length && !isSame(arr[j], arr[j + 1])) {
                        max += arr[++j];
                        ans = Math.max(max, ans);
                    }
            }
        }
        int min = min(arr);
        System.out.println(ans > min ? ans : min);
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (i < min)
                min = i;
        }
        return min;
    }

    static boolean isSame(int a, int b) {
        return (a - b) % 2 == 0;
    }
}