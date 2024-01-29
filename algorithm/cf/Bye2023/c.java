package cf.Bye2023;

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
        int n = sc.nextInt();
        
        int[][] arr = new int[size][1];
        int first = Integer.valueOf(Double.toString(Math.sqrt(size / 10)));
        int end = Integer.valueOf(Double.toString(Math.sqrt(size)));
        for (int i = first; i < end; i++) {
            int num = i * i;
        }
    }
}

class multiset {
    int[][] set;

    public multiset(int n) {
        int size = 1;
        for (int i = 0; i < n + 1; i++) {
            size *= 10;
        }
        set = new int[size][]
    }
    void add(int num) {
        set[]
    }
}
