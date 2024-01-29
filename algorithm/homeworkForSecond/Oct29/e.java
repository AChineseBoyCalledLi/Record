package homeworkForSecond.Oct29;

import java.util.Arrays;
import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            double a[] = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            int qianzhui = 0;
            int[] idx = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = a.length - 1; j > 0; j--) {
                    qianzhui = 0;
                    if (j - i + 1 >= 0)
                        for (int j2 = 0; j2 < i; j2++) {
                            qianzhui += a[j - j2];
                        }

                    if (qianzhui >= k) {
                        idx[i] = j;
                    } else {
                        break;
                    }
                }
                System.out.println(idx[i]);
            }
            int bubiyao = 0;
            for (int i = n; i >= 1; i--) {
                if (idx[i] == idx[i - 1]) {
                    bubiyao += 1;
                }
            }
            System.out.println(bubiyao);
        }
        sc.close();
    }
}
