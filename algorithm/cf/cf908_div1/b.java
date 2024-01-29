package cf.cf908_div1;

import java.util.Arrays;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        int na = sc.nextInt();
        int nb = sc.nextInt();
        int[] a = new int[na];
        Integer[] b = new Integer[nb];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b, (a1, a2) -> a2 - a1);
        int[] arr = new int[a.length + b.length];
        int idxb = 0;
        int idxa = 0;
        int idx = 0;
        for (int i = 0; idxa < a.length && idxb < b.length; i++) {
            if (b[idxb] > a[idxa]) {
                System.out.print(b[idxb++]);
                System.out.print(" ");
            } else {
                System.out.print(a[idxa++]);
                System.out.print(" ");
            }
        }
        while (idxa < a.length) {
            System.out.print(a[idxa++]);
            System.out.print(" ");
        }
        while (idxb < b.length) {
            System.out.print(b[idxb++]);
            System.out.print(" ");
        }

        System.out.println();
    }
}
