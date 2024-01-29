package 杭电;

import java.util.Scanner;

public class zhexianfengepingmian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int line = 2;
        for (int i = 2; i <= 2 * n; i++) {
            line += i;
        }
        System.out.println(line - 2 * n);
    }
}
