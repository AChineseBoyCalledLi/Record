package 大工之星.week12;

import java.util.Scanner;

public class f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] tizi = new int[10001];
        tizi[0] = 1;
        int idx = 0;
        boolean fir = true;
        int cnt = 0;
        for (int i = 0; i < tizi.length; i++) {
            if (tizi[i] > 0 && idx < N && fir) {
                if (idx != N - 1)
                    tizi[i]--;
                tizi[i + arr[idx][0]]++;
                tizi[i + arr[idx][1]]++;
                fir = false;
                idx++;
            } else if (tizi[i] > 0 && idx < N) {
                if (idx != N - 1)
                    tizi[i]--;
                tizi[i + arr[idx][0]]++;
                tizi[i + arr[idx][1]]++;
                if (++cnt == 2) {
                    idx++;
                    cnt = 0;
                }
            }
        }
        if (tizi[x] > 0)
            System.out.println("Yes");
        else {
            System.out.println("No");
        }
    }
}
