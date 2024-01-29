package cf.Bye2023;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m == 1) {
            System.out.println(n * n);
            return;

        }
        if (n % m == 0) {
            System.out.println((n / m) * n);
            return;
        }
        int find = find(m, n);
        if (find == 1) {
            System.out.println(m * n);
            return;
        }
        System.out.println(n * find);
    }

    static int find(int m, int n) {
        for (int i = m - 1; i > 1; i--) {
            if (n % i == 0 && m % i == 0)
                return i;
        }
        return 1;
    }
}
