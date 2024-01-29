import java.util.Scanner;

public class c3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int G = sc.nextInt();
            int L = sc.nextInt();
            int k = 1;
            int smallest = L;
            int K = 1;
            for (int i = G; i <= smallest; i += G) {
                if (L % i != 0)
                    continue;
                k = K;
                for (int j = smallest; j >= i; j = L / k) {
                    if (gcd(i, j) == G && lcm(i, j) == L) {
                        System.out.print(i);
                        System.out.println(" " + j);
                        smallest = j;
                        K = k;
                        break;
                    }
                    k++;
                }
            }
        }
        sc.close();
    }

    static int gcd(int a, int b) {
        for (int i = a; i >= 1; i--) {
            if (b % i == 0 && a % i == 0)
                return i;
        }
        return 1;
    }

    static int lcm(int a, int b) {
        for (int i = 1; i <= a; i++) {
            if (i * b % a == 0)
                return i * b;
        }
        return a * b;
    }
}
