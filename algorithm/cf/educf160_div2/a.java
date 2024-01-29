package cf.educf160_div2;

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
        String s = sc.next();
        int len = s.length();
        int q = find(s, (len - 1) / 2);
        if (q == -1)
            System.out.println(-1);
        else
            System.out.println(s.substring(0, q + 1) + " " + s.substring(q + 1));
    }

    static int find(String s, int q) {
        if (q == -1)
            return -1;
        if (s.charAt(q + 1) == '0')
            return find(s, q - 1);
        String s1 = s.substring(0, q + 1);
        String s2 = s.substring(q + 1);
        if (Integer.valueOf(s1) >= Integer.valueOf(s2)) {
            return find(s, q - 1);
        }
        return q;
    }
}
