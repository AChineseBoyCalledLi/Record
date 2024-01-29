package 大工之星.week12;

import java.util.Arrays;
import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] beat = new int[n];
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        StringBuilder[] sb = new StringBuilder[n];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder(strs[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sb[i].charAt(i) == '1') {
                    
                }
            }
        }
    }
}
