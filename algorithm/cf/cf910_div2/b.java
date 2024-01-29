package cf.cf910_div2;

import java.util.ArrayList;
import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int times = 0;

        for (int i = 2; i >= arr.size(); i--) {
            int idx = 0;
            while (arr.indexOf(arr.size() - i) > arr.indexOf(arr.size() - i + 1)) {
                if (arr.indexOf(arr.size() - i) % 2 != 0) {
                    arr.set(i + idx, arr.indexOf(arr.size() - i) / 2 + 1);
                } else {
                    arr.set(arr.indexOf(arr.size() - i), arr.indexOf(arr.size() - i) / 2);
                }
                arr.add(i);
                times++;
            }
        }
        System.out.println(times);
    }
}
