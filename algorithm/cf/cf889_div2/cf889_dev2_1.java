import java.util.Scanner;

public class cf889_dev2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int flag = 0;
        for (int i = 1; i < n + 1; i++) {
            int t = sc.nextInt();
            if (t == i) {
                flag++;
            }
        }
        System.out.println((flag+1)/2);
    }
}
