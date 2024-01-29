import java.util.Scanner;

public class t1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }
        String[] energy = new String[m];
        for (int i = 0; i < m; i++) {
            energy[i] = sc.nextLine();
        }
        int[][] alp = new int[n][26];
        int order = 1;
        for (int i = 0; i < names.length; i++) {
            order = 1;
            for (int j = 0; j < names[i].length(); j++) {
                alp[i][names[i].charAt(j) - 'a'] = order++;
            }
        }
        for (int i = 0; i < alp.length; i++) {
            for (int j = 0; j < energy.length; j++) {
                for (int j2 = 0; j2 < energy[j].length(); j2++) {
                    
                }
            }
        }
        sc.close();
    }
}
