package homeworkForSecond;

import java.util.Arrays;

public class Sep20_mergesort {
    public static void main(String[] args) {
        Sep20_mergesort test = new Sep20_mergesort();
        int[] a = { 4, 6, 6, 2, 1, 3, 8, 3 };
        test.Mergesort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    void Mergesort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            Mergesort(a, p, q);
            Mergesort(a, q + 1, r);
            Merge(a, p, q, r);
        }
    }

    void Merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = a[i + p];
        }
        for (int i = 0; i < right.length - 1; i++) {
            right[i] = a[q + i + 1];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int j1 = 0;
        int j2 = 0;
        for (int i = p; i <= r; i++) {
            if (left[j1] < right[j2]) {
                a[i] = left[j1];
                j1++;
            } else {
                a[i] = right[j2];
                j2++;
            }
        }
    }
}
