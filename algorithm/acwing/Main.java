import java.io.*;
import java.util.*;

public class Main {
    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int m = nextInt();
        int ans = 0;
        p = new int[n + 1];
        kind = new int[n + 1];
        init();
        while (m-- > 0) {
            int rel = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (a > n || b > n) {
                ans++;
            } else {
                int fa = find(a);
                int fb = find(b);
                if (rel == 1) {
                    if (fa == fb && (kind[a] - kind[b]) % 3 != 0) {
                        ans++;
                    } else if (fa != fb) {
                        p[fa] = fb;
                        kind[fa] = kind[b] - kind[a];
                    }
                } else {
                    if (fa == fb && (kind[a] - kind[b] - 1) % 3 != 0)
                        ans++;
                    else if (fa != fb) {
                        p[fa] = fb;
                        kind[fa] = kind[b] - kind[a] + 1;
                    }
                }
            }
        }
        pw.println(ans);
        pw.flush();
    }

    static int flag = 1;

    static int find(int x) {
        if (p[x] != x) {
            int tmp = find(p[x]);
            kind[x] += kind[p[x]];
            p[x] = tmp;
        }
        return p[x];
    }

    static void init() {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }

    static int[] kind;
    static int[] p;
}