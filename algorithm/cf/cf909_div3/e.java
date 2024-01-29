package cf.cf909_div3;

import java.util.Scanner;

public class e {
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
        int minidx = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minidx]) {
                minidx = i;
            }
        }
        for (int i = minidx; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(minidx);
    }
}
