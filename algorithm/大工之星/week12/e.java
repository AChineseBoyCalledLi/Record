package 大工之星.week12;

import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long lim = sc.nextLong();
        int ans = 0;
        boolean isp = true;
        for (int i = 2; lim / i >= 1; i++) {
            isp = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isp = false;
                    break;
                }
            }
            if (isp) {
                System.out.println(i);
                lim /= i;
                ans++;
            }
        }
        System.out.println(ans);

    }

}
