
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
        int cities = sc.nextInt();
        int[] spend = new int[cities];
        for (int i = 0; i < spend.length; i++) {
            spend[i] = sc.nextInt();
        }
        int query = sc.nextInt();
        int[][] queries = new int[2][query];
        for (int i = 0; i < queries.length; i++) {
            queries[0][i] = sc.nextInt();
            queries[1][i] = sc.nextInt();
        }
        int[] miniSpend1 = new int[cities];
        miniSpend1[cities - 1] = 1;
        for (int i = 1; i < miniSpend1.length - 1; i++) {
            int pos = spend[i] - spend[i - 1];
            int neg = spend[i + 1] - spend[i];
            if (pos <= neg)
                miniSpend1[i] = 1;
            else
                miniSpend1[i] = pos;
        }
        for (int i = 1; i < miniSpend1.length; i++) {
            miniSpend1[i] = miniSpend1[i] + miniSpend1[i - 1];
        }

        int[] miniSpend2 = new int[cities];
        miniSpend2[0] = 1;
        for (int i = miniSpend2.length - 2; i > 0; i--) {
            int pos = spend[i] - spend[i - 1];
            int neg = spend[i + 1] - spend[i];
            if (pos >= neg)
                miniSpend2[i] = 1;
            else
                miniSpend2[i] = neg;
        }
        for (int i = miniSpend2.length - 2; i >= 0; i--) {
            miniSpend2[i] = miniSpend2[i + 1] + miniSpend2[i];
        }
        for (int i = 0; i < queries[0].length; i++) {
            int a1 = queries[0][i] - 1;
            int a2 = queries[1][i] - 1;
            if (a1 < a2) {
                System.out.println(miniSpend1[a2] - miniSpend1[a1]);
            } else {
                System.out.println(miniSpend2[a1] - miniSpend2[a2]);
            }
        }
    }
}
