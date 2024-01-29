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
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == c.charAt(i) || b.charAt(i) == c.charAt(i)) {
                size++;
            }
        }
        if (size == n) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
