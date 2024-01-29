package cf.cf909_div3;

import java.util.ArrayList;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> yue = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr.length % i == 0)
                yue.add(i);
        }
        long diff = 0;
        for (Integer integer : yue) {
            long[] sub = new long[arr.length / integer];
            for (int i = 0; i < arr.length; i += integer) {
                for (int j = i; j < i + integer; j++) {
                    sub[i / integer] += arr[j];
                }
            }
            diff = Math.max(max(sub) - min(sub), diff);
        }
        System.out.println(diff);
    }

    static long max(long[] arr) {
        long max = arr[0];
        for (long i : arr) {
            if (i > max)
                max = i;
        }
        return max;
    }

    static long min(long[] arr) {
        long min = arr[0];
        for (long i : arr) {
            if (i < min)
                min = i;
        }
        return min;
    }
}
