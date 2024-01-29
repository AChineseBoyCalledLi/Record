package Exercise.洛谷;

import java.util.Scanner;

public class p5715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int n = sc.nextInt();
        int x = sc.nextInt();
        int sum = 0;
        if (n >= x)
            sum++;
        int nn = n;
        while (nn / 10 >= x) {
            nn /= 10;
            if (nn % 10 >= x)
                sum++;
            sum++;
        }
        sum += n / 10;
        System.out.println(sum);
        sc.close();
    }
}
