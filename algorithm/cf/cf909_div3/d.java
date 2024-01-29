package cf.cf909_div3;

import java.util.Arrays;
import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int len = sc.nextInt();
        if (len == 1) {
            sc.nextInt();
            System.out.println(0);
            return;
        }
        double[] arr = new double[len];
        double[] mut = new double[len * len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                mut[idx++] = arr[i] * arr[j];
            }
        }
        Arrays.sort(mut);
        int ans = 0;
        for (int i = 1; i < mut.length; i++) {
            if (mut[i] == mut[i - 1] && mut[i] != 0)
                ans++;
        }
        System.out.println(ans);
    }
}
