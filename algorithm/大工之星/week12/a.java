package 大工之星.week12;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if (num > max) {
                if (num == 5 && max == 1)
                    ;
                else {
                    max = num;
                }
            } else if (max == 5 && num == 1) {
                max = 1;
            }
        }
        System.out.println(max);
        sc.close();
    }
}
