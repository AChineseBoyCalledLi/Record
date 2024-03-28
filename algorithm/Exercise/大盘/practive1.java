import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class practive1 {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    // static int[] de = new int[1010];
    // static boolean[] flag = new boolean[1010];
    // static int[] by = new int[1010];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] orig = br.readLine().split(" ");
        int m = nextInt();
        String[][] sts = new String[m + 1][];
        for (int i = 1; i < sts.length; i++) {
            sts[i] = br.readLine().split(" ");
        }
    }

    static int[] arr;

    public static void find(int l, int r) {

    }

    static class Tree {
        int left;
        int right;

        public Tree(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

}
