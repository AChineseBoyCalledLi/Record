package Exercise.小算法;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("abcdef");
        System.out.println(permutationA(sb, new StringBuffer("   "), 0));
        // int[] option = { 1, 2, 5 };
        // System.out.println(coins(option, new ArrayList<>(), 15));
    }

    static int permutationA(StringBuffer orig, StringBuffer dest, int pos) {
        if (pos == dest.length()) {
            System.out.println(dest);
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < orig.length(); i++) {
            dest.setCharAt(pos, orig.charAt(i));
            orig.deleteCharAt(i);
            ret += permutationA(orig, dest, pos + 1);
            orig.insert(i, dest.charAt(pos));
        }
        return ret;
    }

    static void Combination(StringBuffer orig, StringBuffer dest, int pos) {
        if (pos == dest.length()) {
            System.out.println(dest);
            return;
        }
        while (orig.length() != 0) {
            dest.setCharAt(pos, orig.charAt(0));
            orig.deleteCharAt(0);
            Combination(new StringBuffer(orig), dest, pos + 1);
        }
    }

    static int coins(int[] option, ArrayList<Integer> solution, int total) {
        if (total == 0) {
            System.out.println(solution);
            return 1;
        } else if (total < 0)
            return 0;
        int ret = 0;
        for (int i = 0; i < option.length; i++) {
            if (!solution.isEmpty() && option[i] < solution.get(solution.size() - 1))
                continue;
            solution.add(option[i]);
            ret += coins(option, new ArrayList<>(solution), total - option[i]);
            solution.remove(Integer.valueOf(option[i]));
        }
        return ret;
    }

}
