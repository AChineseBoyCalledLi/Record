package Exercise.小算法;

import java.util.Arrays;
import java.util.Stack;

public class monoStack {
    public static void main(String[] args) {
        int[] a = { 1, -23, 0, 3, 32, 1, 2 };
        Stack<Integer> s = new Stack<>();
        int[] idx = new int[a.length];
        s.push(0);
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && a[i] < a[s.peek()]) {
                idx[s.pop()] = i;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            idx[s.pop()] = -1;
        }
        System.out.println(Arrays.toString(idx));
    }
}
