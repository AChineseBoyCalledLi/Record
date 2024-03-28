import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class b {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    public static void main(String[] args) {
        int n = nextInt();
        for (int i = 0; i < n; i++) {

        }
        pw.flush();
    }

    static void solve() {
        int n = nextInt();
        Fire[] fires = new Fire[n];
        for (int i = 0; i < n; i++) {
            fires[i] = new Fire(nextInt(), nextInt());
        }
        Arrays.sort(fires);
        boolean left = false;
        boolean right = false;
        for (int i = 0; i < fires.length; i++) {
            if (fires[i].x <= 0 && isRight(fires, i - 1, i)) {
                left = true;
            } else if (fires[i].x >= 0 && isRight(fires, i, i + 1)) {
                right = true;
            }
        }
        if (left && right) {
            pw.println(0);
            return;
        }
        int sum = 0;
        Arrays.binarySearch(fires, new Fire(0, 0));
    }

    static boolean isRight(Fire[] arr, int i, int j) {
        if (i < 0)
            return false;
        if (j >= arr.length)
            return false;
        if (arr[j].x - arr[i].x > 1)
            return false;
        if (arr[j].y == arr[i].y)
            return false;
        return true;
    }

    static class Fire implements Comparable<Fire> {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(b.Fire o) {
            return this.x - o.x;
        }

        @Override
        public boolean equals(Object obj) {
            Fire f = (Fire) obj;
            return this.x == f.x;
        }
    }
}
