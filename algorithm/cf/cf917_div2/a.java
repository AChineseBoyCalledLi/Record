package cf.cf917_div2;

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
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int pos = 0;
        int neg = 0;
        boolean zero = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                pos++;
            else if (a[i] < 0)
                neg++;
            else
                zero = true;
        }
        if (zero) {
            System.out.println(0);
            return;
        }
        if (neg == 0) {
            System.out.println(1);
            System.out.println(1 + " " + 0);
            return;
        }
        if (neg % 2 != 0) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
        System.out.println(1 + " " + 0);
    }
}
