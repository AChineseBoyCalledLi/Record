package Exercise.赛氪.第四届大学生算法设计与编程挑战赛;

import java.util.Arrays;
import java.util.Scanner;

public class cut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arrs = new long[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = sc.nextLong();
        }
        Arrays.sort(arrs);
        long sum = 0;
        for (int i = arrs.length - 2; i >= 0; i--) {
            arrs[i] += arrs[i + 1];
        }
        for (int i = 0; i < arrs.length - 1; i++) {
            sum += arrs[i];
        }
        System.out.println(sum);
        sc.close();
    }
}
