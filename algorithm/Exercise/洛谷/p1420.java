package Exercise.洛谷;

import java.util.Scanner;

public class p1420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ans = 0;
            int pre = sc.nextInt();
            int idx1 = 0;
            for (int i = 1; i < n; i++) {
                int sum = 1;
                while (i < n) {
                    int cur = sc.nextInt();
                    if (cur - pre != i - idx1) {
                        pre = cur;
                        idx1 = i;
                        break;
                    }
                    sum++;
                    i++;
                }
                ans = Math.max(ans, sum);
            }
            System.out.println(ans);
        }

        sc.close();
    }
}
