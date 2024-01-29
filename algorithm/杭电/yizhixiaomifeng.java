package 杭电;

import java.util.Scanner;

public class yizhixiaomifeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        long sum = 0;
        long f = 0;
        long s = 1;
        for (int i = start; i < end; i++) {
            sum = s + f;
            f = s;
            s = sum;
        }
        System.out.println(sum);
    }
}
