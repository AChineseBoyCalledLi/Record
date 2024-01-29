package cf.cf889_div2;
import java.util.Scanner;

public class cf889_dev2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        if (isPositive(arr)) {
            System.out.println(len - 1);

            for (int i = 1; i < len; i++) {
                System.out.println((i + 1) + " " + i);
            }
        }
        if (isNegative(arr)) {
            System.out.println(len - 1);
            for (int i = len; i > 1; i++) {
                System.out.println((i - 1) + " " + i);
            }
        }
        if (isBlended(arr)) {

        }
    }

    public static boolean judge(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1])
                return false;
        }
        return true;
    }

    public static boolean isPositive(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0)
                return false;
        }
        return true;
    }

    public static boolean isNegative(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                return false;
        }
        return true;
    }

    public static boolean isBlended(int[] a) {
        return !(isNegative(a) || isPositive(a));
    }
}
