import java.util.ArrayList;
import java.util.Arrays;
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
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> orig = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            orig.add(arr[i]);
        }
        System.out.println(combination(orig, new ArrayList<>()));
    }

    static int combination(ArrayList<Integer> orig, ArrayList<Integer> des) {
        if (des.size() == 3) {
            if ((des.get(0) + des.get(1)) > des.get(2) && (des.get(2) + des.get(1)) > des.get(0)
                    && (des.get(0) + des.get(2)) > des.get(1))
                return 1;
            System.out.println(des);
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < orig.size(); i++) {
            des.add(orig.get(i));
            orig.remove(i);
            ret += combination(orig, des);
            des.remove();
            orig.add(i, des.get(i));
        }
        return ret;
    }
}
