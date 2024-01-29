package Exercise.大盘.test;

import java.util.Scanner;
import java.util.Stack;

public class a1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        Stack<Character> stk = new Stack<>();
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (t == 'M' || t == 'G' || t == 'K') {
                if (stk.isEmpty()) {
                    stk.add(t);
                } else if (stk.peek() == t)
                stk.pop();
            else
                stk.add(t);
            }
        }
        if (stk.isEmpty()) {
            System.out.println(1);
        }else System.out.println(0);
    }
}
