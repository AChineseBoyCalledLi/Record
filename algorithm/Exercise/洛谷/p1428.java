package Exercise.洛谷;

import java.util.Scanner;

public class p1428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                int sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j])
                        sum++;
                }
                System.out.print(sum);
                System.out.print(" ");
            }
        }
        sc.close();
    }
}
