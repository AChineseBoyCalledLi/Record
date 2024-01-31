package nowcoder.递归分治;

import java.util.Scanner;

public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        help(num);
        sc.close();
    }

    static void help(int num) {
        if (num % 10 == num) {
            System.out.println(num);
            return;
        }
        int aux = 0;
        while (num != 0) {
            aux += (int) num % 10;
            num /= 10;
        }
        help(aux);
    }
}
