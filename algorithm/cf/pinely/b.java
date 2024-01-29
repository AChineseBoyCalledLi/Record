package cf.pinely;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if (n == 2) {
            System.out.println(arr[1]);
            return;
        }
        // 前两个是余数

        int[] yumen = find(arr[1] - arr[0]);
        for (int i = 0; i < yumen.length; i++) {
            if (isOK(arr, yumen[i])) {
                System.out.println(yumen[i]);
                return;
            }
        }
        yumen = find(arr[2] - arr[1]);
        for (int i = 0; i < yumen.length; i++) {
            if (isOK(arr, yumen[i])) {
                System.out.println(yumen[i]);
                return;
            }
        }
    }

    static boolean isOK(int[] a, int yu) {
        int[] yus = new int[2];
        for (int i = 0; i < yus.length; i++) {
            yus[i] = -1;
        }
        for (int i = 0; i < a.length; i++) {
            int yushu = a[i] % yu;
            if (yus[0] < 0) {
                yus[0] = yushu;
            }
            if (yushu == yus[0])
                continue;
            if (yus[1] < 0) {
                yus[1] = yushu;
            }
            if (yushu == yus[1])
                continue;
            return false;
        }
        if (yus[1] < 0)
            return false;
        return true;
    }

    static int[] find(int a) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = a; i > 1; i--) {
            if (a % i == 0)
                arr.add(i);
        }
        int[] b = new int[arr.size()];
        int i = 0;
        for (int num : arr) {
            b[i++] = num;
        }
        return b;
    }
}
