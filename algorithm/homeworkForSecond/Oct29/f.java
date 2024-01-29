package homeworkForSecond.Oct29;

import java.util.Scanner;

public class f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ')
                    sum++;
                else if (str.charAt(i) - 'a' + 1 <= 15) {
                    sum += (str.charAt(i) - 'a') % 3 + 1;
                } else if (str.charAt(i) - 'a' + 1 <= 19) {
                    sum += (str.charAt(i) - 'p') % 4 + 1;
                } else if (str.charAt(i) - 'a' + 1 <= 22) {
                    sum += (str.charAt(i) - 't') % 3 + 1;
                } else {
                    sum += (str.charAt(i) - 'w') % 4 + 1;
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
