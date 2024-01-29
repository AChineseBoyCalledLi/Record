package newcoder.递归分治;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class a2 {

    public static void main(String[] args) throws Exception {
        Scan sc = new Scan();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.println(find(n) + " " + ((1L << find(n)) - 1));
        }
    }

    static long find(long n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return find(n / 2) + find(n % 2);
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long nextLong() throws Exception {
            return Long.parseLong(br.readLine());
        }

        int nextInt() throws Exception {
            return Integer.parseInt(br.readLine());
        }
    }
}
