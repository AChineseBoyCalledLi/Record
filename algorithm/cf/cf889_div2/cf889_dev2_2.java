import java.util.Scanner;

public class cf889_dev2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        long num = sc.nextLong();
        int max = 1;
        long i=2;
        while (num % i == 0) {
            max++;
            i++;
        }
        System.out.println(max);
    }
}
