package Exercise.洛谷;

import java.util.Deque;
import java.util.LinkedList;

import java.util.Scanner;

public class p1886 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Deque<Integer> D = new LinkedList<>();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            while (!D.isEmpty() && D.peekLast() > arr[i])
                D.pollLast();
            D.addLast(i);
            if (i >= k - 1) {
                while (!D.isEmpty() && D.peekFirst() <= i - k)
                    D.pollFirst();
                System.out.print(arr[D.peekFirst()]);
                System.out.print(' ');
            }
        }
        System.out.println();
        D = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!D.isEmpty() && D.peekLast() < arr[i])
                D.pollLast();
            D.addLast(i);
            if (i >= k - 1) {
                while (!D.isEmpty() && D.peekFirst() <= i - k)
                    D.pollFirst();
                System.out.print(arr[D.peekFirst()]);
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
