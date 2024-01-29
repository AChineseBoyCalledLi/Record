package homeworkForSecond.Oct29;

import java.util.Scanner;

public class i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] q = new int[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                a[i] = x / 10;
                q[i] = x % 10;
            }
            long sum = 0;
            for (int i = 0; i < q.length; i++) {
                sum += (long) Math.pow(a[i], q[i]);
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
