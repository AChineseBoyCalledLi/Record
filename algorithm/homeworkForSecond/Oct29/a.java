package homeworkForSecond.Oct29;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long a = sc.nextLong();
            int sum = 0;
            for (int i = 0; i < 32; i++) {
                if (a >> i == 0)
                    break;
                if (((a >> i) & 1) == 0)
                    sum++;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
