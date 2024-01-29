package cf.cf909_div3;

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
        if (n % 3 != 0)
            System.out.println("First");
        else {
            System.out.println("Second");
        }
    }
}
