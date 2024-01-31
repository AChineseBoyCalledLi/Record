package nowcoder.递归分治;

import java.io.*;
import java.util.ArrayList;

public class a11 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String mid = bf.readLine();
        String hou = bf.readLine();
        tree = new ArrayList<>();
        solve(mid, hou);
        for (Character c : tree) {
            pw.write(c);
        }
        pw.flush();
    }

    static ArrayList<Character> tree;

    static void solve(String mid, String hou) {
        if (mid.length() == 0)
            return;
        if (mid.length() == 1) {
            tree.add(mid.charAt(0));
            return;
        }
        char root = hou.charAt(hou.length() - 1);
        int idx = mid.indexOf(root);
        String left_mid = mid.substring(0, idx);
        String left_hou = hou.substring(0, idx);
        String right_mid = mid.substring(idx + 1, mid.length());
        String right_hou = hou.substring(idx, mid.length() - 1);
        tree.add(root);
        solve(left_mid, left_hou);
        solve(right_mid, right_hou);
    }
}
