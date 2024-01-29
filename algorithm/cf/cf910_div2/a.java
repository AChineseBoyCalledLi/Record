package cf.cf910_div2;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'B')
                cnt++;
        }
        if (cnt == k) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
        if (cnt > k) {
            int dif = cnt - k;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'B')
                    dif--;
                if (dif == 0) {
                    System.out.println(i + 1 + " A");
                    return;
                }
            }
        } else {
            int dif = k - cnt;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A')
                    dif--;
                if (dif == 0) {
                    System.out.println(i + 1 + " B");
                    return;
                }
            }
        }
    }
}
