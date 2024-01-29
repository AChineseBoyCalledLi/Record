package Exercise.大盘.test;

import java.util.Scanner;

public class a1028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] arr = new double[n][];
        for (int i = 0; i < arr.length; i++) {
            sc.nextLine();
            String str = sc.nextLine();
            arr[i] = new double[str.length()];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '.') {
                    arr[i][j] = 1;
                }
                if (str.charAt(j) == '&') {
                    arr[i][j] = 2;
                }
                if (str.charAt(j) == '%') {
                    arr[i][j] = 0.5;
                }
                if (str.charAt(j) == '$') {
                    arr[i][j] = 5;
                }
            }
        }
        double[][] newarr = new double[n][];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = new double[arr[i].length];
        }

        for (int i = 0; i < newarr.length; i++) {
            for (int j = 0; j < newarr[i].length; j++) {
                newarr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 2; j >= 0; j--) {
                arr[i][j] = arr[i][j + 1];
            }
        }
        double sum = 0;
        int dao = 0;
        int newdao = 0;
        sum += newarr[0][0];
        for (int i = 1; i < newarr[0].length; i++) {
            double min = arr[dao][i];
            for (int j = 0; j < newarr.length; j++) {
                if (min > 2 * Math.abs(j - dao) + arr[j][i]) {
                    min = 2 * Math.abs(j - dao) + arr[j][i];
                    newdao = j;
                }
            }
            sum += newarr[newdao][i] + 2 * Math.abs(newdao - dao);
            dao = newdao;
        }
        System.out.println(sum);
        sc.close();
    }
}
