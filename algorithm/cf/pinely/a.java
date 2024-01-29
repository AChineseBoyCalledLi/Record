package cf.pinely;

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
        boolean[] a = new boolean[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = false;
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > 0)
                a[2] = true;
            if (x < 0)
                a[3] = true;
            if (y > 0)
                a[0] = true;
            if (y < 0)
                a[1] = true;
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i])
                sum++;
        }
        if (sum <= 3) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
