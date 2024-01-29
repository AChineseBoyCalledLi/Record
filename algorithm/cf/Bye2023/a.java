package cf.Bye2023;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int product = 1;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            product *= a[i];
        }
        if (2023 % product != 0) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        System.out.print(2023 / product + " ");
        for (int i = 0; i < m - 1; i++) {
            System.out.print(1);
            System.out.print(" ");
        }
        System.out.println();
    }

}
