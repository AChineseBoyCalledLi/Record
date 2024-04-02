import java.util.Scanner;

public class Main1 {
    static int n;
    static long res = 0;
    static int MOD = 1000000009;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        System.out.println(dfs(1, 1));
    }

    public static long dfs(int index, int money) {
        long ans = 0;
        if (index == n && money == 1) {
            return n;
        }
        if (index == n && money > 1) {
            return 1;
        }
        if (money > 1)
            dfs(index + 1, money - 1);
        for (int i = 1; i <= n; i++) {
            ans += dfs(index + 1, i) % MOD;
        }
        return ans;
    }

}
