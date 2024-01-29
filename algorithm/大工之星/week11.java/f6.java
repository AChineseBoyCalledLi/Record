import java.util.Scanner;

public class f6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int len = (n + 1) / 2;
        int[] newarr = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < i + len; j++) {
                newarr[j - i] = arr[j];
            }
            System.out.println(gcd(len, newarr));
        }

    }

    static int gcd(int n, int[] arr) {
        if (n == 1)
            return arr[0];
        int[] newarr;
        int j = 0;
        if (n % 2 == 1) {
            newarr = new int[n / 2 + 1];
            for (int i = 0; i < newarr.length; i++) {
                if (j <= arr.length - 2) {
                    newarr[i] = gcd(arr[j++], arr[j++]);
                } else {
                    newarr[i] = arr[j];
                }
            }
        } else {
            newarr = new int[n / 2];
            for (int i = 0; i < newarr.length; i++) {
                newarr[i] = gcd(arr[j++], arr[j++]);
            }
        }
        return gcd(newarr.length, newarr);
    }

    static int gcd(int a, int b) {
        for (int i = a; i >= 1; i--) {
            if (b % i == 0 && a % i == 0)
                return i;
        }
        return 1;
    }
}
