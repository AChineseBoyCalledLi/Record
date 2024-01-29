package homeworkForSecond.Oct29;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class j {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = 0;
            int A = 0;
            int B = 0;
            n = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();
            BigDecimal[] magictiemvalue = new BigDecimal[n];
            for (int i = 0; i < n; i++) {
                magictiemvalue[i] = new BigDecimal(sc.next());
            }
            Arrays.sort(magictiemvalue);
            BigDecimal sum = new BigDecimal("0");
            BigDecimal a = new BigDecimal("" + A);
            for (int i = 0; i < A; i++) {
                sum = sum.add(magictiemvalue[n - 1 - i].divide(a));
            }

            System.out.println(sum.floatValue());
            int number = 0;
            int same = 0;
            int i = 0;
            for (BigDecimal t : magictiemvalue) {
                if (t.equals(magictiemvalue[n - A])) {
                    same++;
                } else {
                    if (t.compareTo(magictiemvalue[n - A]) > 0) {
                        i++;
                    }
                }
            }
            if (magictiemvalue[n - A - 1].equals(magictiemvalue[n - 1])) {
                int size = A;
                while (same >= size && size <= B) {
                    number += comb(same, size);
                    size++;
                }
            } else {
                number = comb(same, A - i);
            }
            System.out.println(number);

        }
        sc.close();

    }

    public static int jc(int n) {
        if (n == 0)
            return 1;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static int comb(int sum, int tar) {
        return jc(sum) / (jc(tar) * jc(sum - tar));
    }
}
