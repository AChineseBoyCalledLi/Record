package cf.educf152_div2;
import java.util.Scanner;

public class educf152_dev2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            int ans = solve(sc);
            System.out.println(ans);
        }
    }

    public static int solve(Scanner sc) {
        int b = sc.nextInt();
        int c = sc.nextInt();
        int h = sc.nextInt();
        int ans = 0;
        if (b > c + h) {
            ans = 1 + c + h + c + h;
        } else {
            ans = b + b - 1;
        }
        return ans;
    }
}
