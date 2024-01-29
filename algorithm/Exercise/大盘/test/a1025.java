package Exercise.大盘.test;

import java.util.Scanner;

public class a1025 {
    static int acc[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        acc = new int[26];
        int odd = 0;
        int even = 0;
        for (int i = 0; i < acc.length; i++) {
            acc[i] = 0;
        }
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            solve(sc);
        }
        for (int i = 0; i < acc.length; i++) {
            if (acc[i] % 2 == 0 && acc[i] != 0) {
                even++;
            } else if(acc[i]%2!=0)
                odd++;
        }
        System.out.println(odd);
        System.out.print(even);
    }

    static void solve(Scanner sc) {
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            acc[str.charAt(i) - 97]++;
        }
    }
}
