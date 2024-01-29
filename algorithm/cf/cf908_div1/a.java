package cf.cf908_div1;

import java.util.Scanner;

public class a {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        k = Math.min(n, k);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int idx = 0;
        int len = arr.length;
        for (int i = 0; i < k; i++) {
            int end = len - idx;
            if (arr[end - 1] > len) {
                System.out.println("No");
                return;
            }
            if (arr[end - 1] == len) {
                System.out.println("Yes");
                return;
            }
            idx = (idx + arr[end - 1]) % len;
        }
        System.out.println("Yes");

    }

}
