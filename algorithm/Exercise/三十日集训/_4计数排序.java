package Exercise.三十日集训;

import java.util.Arrays;

public class _4计数排序 {
    static int[] a = { 2, 34, 3, 22, 432, 0, 233 };

    public static void main(String[] args) {
        countingsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void countingsort(int[] A) {
        int[] cnt = new int[max(A) + 1];
        for (int i : A) {
            cnt[i]++;
        }
        int top = 0;
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] != 0) {
                A[top++] = i;
                cnt[i]--;
            }
        }
    }

    public static int max(int[] A) {
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (greater(A[i], max)) {
                max = A[i];
            }
        }
        return max;
    }

    public static boolean greater(int i, int j) {
        return i - j > 0;
    }
}
