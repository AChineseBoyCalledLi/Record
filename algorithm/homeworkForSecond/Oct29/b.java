package homeworkForSecond.Oct29;

import java.util.Arrays;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] citys = new int[m][2];
            for (int i = 0; i < m; i++) {
                citys[i][0] = sc.nextInt();
                citys[i][1] = sc.nextInt();
            }
            int k = sc.nextInt();
            int meeting[][] = new int[k][2];
            for (int i = 0; i < k; i++) {
                meeting[i][0] = sc.nextInt();
                meeting[i][1] = sc.nextInt();
            }
            int[] inter = new int[n + 1];
            for (int i = 0; i < inter.length; i++) {
                inter[i] = i;
            }
            for (int i = 0; i < citys.length; i++) {
                int big = citys[i][0];
                int small = citys[i][1];
                if (big < small) {
                    int t = big;
                    big = small;
                    small = t;
                }
                if (inter[big] != big) {
                    if (inter[big] < inter[small]) {
                        inter[small] = inter[big];
                    } else
                        inter[big] = inter[small];
                } else {
                    inter[big] = inter[small];
                }
            }

            int meet[] = new int[n + 1];
            for (int i = 1; i < meet.length; i++) {
                meet[i] = i;
            }
            int[] sum = new int[n + 1];
            for (int i = 0; i < meeting.length; i++) {
                int small = meeting[i][0];
                int big = meeting[i][1];
                if (meeting[i][0] > meeting[i][1]) {
                    big = meeting[i][0];
                    small = meeting[i][1];
                }
                if (inter[small] != inter[big])
                    continue;
                if (meet[big] != big) {
                    if (meet[big] < meet[small]) {
                        meet[small] = meet[big];
                    } else
                        meet[big] = meet[small];
                } else {
                    meet[big] = meet[small];
                }
                if (meet[big] == meet[small]) {
                    sum[meet[big]]++;
                }
            }
            for (int i = 0; i < meet.length; i++) {
                if (meet[i] != i && sum[meet[i]] != 0) {
                    sum[i] = sum[meet[i]];
                }
            }
            Arrays.sort(sum);
            int max = sum[n] + 1;
            int min = sum[1] + 1;
            System.out.println(max + " " + min);
        }
        sc.close();
    }

}
