package Exercise.洛谷;

import java.util.Scanner;

public class T23713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arrs = new double[n];
        int re = sc.nextInt();
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = sc.nextDouble();
        }
        for (int i = 0; i < re; i++) {
            solve(arrs, sc);
        }
    }

    static void solve(double[] arrs, Scanner sc) {
        int w = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (w == 0) {
            double sum = 0;
            for (int i = a - 1; i < b; i++) {
                sum += arrs[i];
            }
            System.out.println(sum);
        } else if (w == 1) {
            while (a < b) {
                double t = arrs[a];
                arrs[a++] = arrs[b];
                arrs[b--] = t;
            }
        } else if (w == 2) {
            for (int i = a - 1; i < b; i++) {
                arrs[i] += c;
            }
        } else if (w == 3) {
            for (int i = a - 1; i < b; i++) {
                arrs[i] *= c;
            }
        } else if (w == 4) {
            for (int i = a - 1; i < b; i++) {
                arrs[i] = Math.sqrt(arrs[i]);
            }
        } else if (w == 5) {
            int j = 1;
            for (int i = a - 1; i < b; i++) {
                arrs[i] += c * j++;
            }
        } else if (w == 6) {
            int k = b + 1;
            while (a != b) {
                double t = arrs[a];
                arrs[a++] = arrs[k];
                arrs[k++] = t;
            }
        }

    }

}
