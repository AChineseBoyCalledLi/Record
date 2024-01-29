package cf.cf917_div2;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int len = sc.nextInt();
        String s = sc.next();
        rec(s);
    }

    static int rec(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.length() == 1)
            return 1;
        if (sb.charAt(0) == sb.charAt(1)) {
            sb.deleteCharAt(0);
            return 1 + rec(sb.toString());
        }
        StringBuilder a0 = new StringBuilder();
        a0.append(sb.charAt(0));
        String s1 = sb.deleteCharAt(0).toString();
        String s2 = a0.append(sb.substring(1)).toString();
        System.out.println(s1.length() + " " + s2.length());
        return 1 + rec(s2) + rec(s1);
    }
}
