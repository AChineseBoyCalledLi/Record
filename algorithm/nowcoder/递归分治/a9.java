package nowcoder.递归分治;

import java.io.*;

public class a9 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static void init() {
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        mem[0] = 0;
    }

    public static void main(String[] args) throws IOException {
        String str;
        mem = new long[27];
        init();
        while ((str = bf.readLine()) != null) {
            int n = Integer.parseInt(str);
            System.out.println(solve(n));
        }
    }

    static long[] mem;

    static long solve(int n) {
        if (mem[n] != -1)
            return mem[n];
        mem[n] = 3 * mem[n - 1] + 2;
        return mem[n];
    }

}
