package homeworkForSecond.Oct29;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int max = n % 2 == 0 ? n - 1 : n;
            int sum = max / 2 + 1;
            sum += n / 4;
            System.out.println(sum);
        }
        sc.close();
    }
}
