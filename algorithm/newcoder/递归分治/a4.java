package newcoder.递归分治;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class a4 {
    public static void main(String[] args) throws Exception {
        Scan sc = new Scan();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        Grade[] arr = new Grade[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Grade(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(arr);
        int limit = (int) (m * 1.5);
        while (limit < arr.length && arr[limit].score == arr[limit - 1].score) {
            limit++;
        }
        pw.println(arr[limit - 1].score + " " + limit);
        for (int i = 0; i < limit; i++) {
            pw.println(arr[i]);
        }
        pw.flush();
    }

    static class Grade implements Comparable<Grade> {
        int id;
        int score;

        public Grade(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return id + " " + score;
        }

        @Override
        public int compareTo(Grade o) {
            int ret = o.score - this.score;
            if (ret == 0) {
                ret += this.id - o.id;
            }
            return ret;
        }
    }

    static class Scan {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(bf);

        int nextInt() throws Exception {
            st.nextToken();
            return (int) st.nval;
        }

        long nextLong() throws Exception {
            st.nextToken();
            return (long) st.nval;
        }

        String next() throws Exception {
            st.nextToken();
            return st.sval;
        }

        String nextLine() throws Exception {
            return bf.readLine();
        }
    }
}
