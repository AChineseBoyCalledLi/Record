package Exercise.洛谷;

import java.util.Scanner;

public class CF1A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();
        long a = sc.nextLong();
        System.out.println(((m + a - 1) / a) * ((n + a - 1) / a));
        sc.close();
    }
}
