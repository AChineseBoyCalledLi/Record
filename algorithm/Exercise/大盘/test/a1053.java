package Exercise.大盘.test;

import java.util.Scanner;

public class a1053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] amount = new int[n];
        for (int i = 0; i < n; i++) {
            amount[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < amount.length; i++) {
            sum += amount[i];
        }
        int position = sc.nextInt();
        System.out.println(sum + position + amount.length - 2);
        sc.close();
    }
}
