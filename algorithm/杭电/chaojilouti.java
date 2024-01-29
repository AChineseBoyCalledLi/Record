package 杭电;

import java.util.Scanner;

public class chaojilouti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        long a0 = 0;
        long a1 = 1;
        long now = 1;
        for (int i = 1; i < n; i++) {
            now = a1 + a0;
            a0 = a1;
            a1 = now;
        }
        System.out.println(a1);
    }
}
