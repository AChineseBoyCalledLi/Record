package cf.cf910_div2;

import java.util.ArrayList;
import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (b[i] == a[i]) {
                idx.add(i);
            }
        }
        if (idx.size() != 1) {
            for (int i = 1; i < idx.size(); i++) {
                int cur = idx.get(i);
                int pre = idx.get(i - 1);
                if (b[cur] != b[idx.get(i - 1)]) {
                    int be = b[cur];
                    b[cur] = b[pre];
                    b[pre] = be;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println(sum);
    }
}
