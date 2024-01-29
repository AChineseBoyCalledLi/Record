package cf.ccpc秦皇岛;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int C = sc.nextInt();
        int cap = C;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (c < C) {
                C -= c;
            } else {
                C = cap;
                sum++;
            }
        }
        System.out.println(sum);
    }
}
