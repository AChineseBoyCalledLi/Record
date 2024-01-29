package cf.educf152_div2;
import java.util.Scanner;

public class educf152_dev2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            solve(sc);
            System.out.println();
        }
    }

    public static void solve(Scanner sc) {

        int a = sc.nextInt();
        int d = sc.nextInt();
        int[] h = new int[a];
        for (int i = 0; i < a; i++) {
            h[i] = sc.nextInt() % d;
            if (h[i] == 0) {
                h[i] = d;
            }
        }
        int max = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (h[max] < h[j])
                    max = j;
            }
            h[max] = 0;
            System.out.print(max + 1 + " ");
        }
    }
}
