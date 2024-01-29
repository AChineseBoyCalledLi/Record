package Exercise.leetcode;

import java.util.Stack;

public class a42 {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int[] idx = new int[height.length];
        s.push(0);
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) {
                idx[s.pop()] = i;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            idx[s.pop()] = -1;
        }
        int sum = 0;
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] != -1 && height[i] != 0) {
                sum += idx[i] - i;
                System.out.println(i + " " + idx[i]);
            }
        }
        return sum;
    }
}
