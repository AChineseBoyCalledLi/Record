package homeworkForSecond;

import java.util.Arrays;

public class Sep20_quicksort {
    public static void main(String[] args) {
        int[] a = {4, 6, 6, 2, 1, 3, 8, 3};
        System.out.println(Arrays.toString(a));
        quicksort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static void quicksort(int[] a, int p, int r){
        if (p<r) {
            int q = partition(a, p, r);
            quicksort(a, p, q-1);
            quicksort(a, q+1, r);
        }
    }
    static int partition(int[]a, int p, int r){
        int x = a[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if (a[j]<x) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, r, i+1);
        return i+1;
    }
    static void swap(int[] a, int a1, int a2){
        int t = a[a1];
        a[a1]= a[a2];
        a[a2] = t;
    }
}
