package Exercise.洛谷;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1540 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (Q.contains(t)) {
                continue;
            } else {
                if (Q.size() < m) {
                    Q.add(t);
                    res++;
                } else {
                    Q.poll();
                    Q.add(t);
                    res++;
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
