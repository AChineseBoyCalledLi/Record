import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class a4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static char[][][] maps = new char[105][105][105];
    static int n;
    static boolean flag = true;
    static char[][][] a;
    static int[][][] stu;
    static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static void bfs() {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(0, 0, 0));
        stu[0][0][0] = 1;
        while (!Q.isEmpty()) {
            Node v = Q.poll();
            if (v.x == v.y && v.y == v.z && v.z == n - 1) {
                flag = false;
                pw.println(stu[v.x][v.y][v.z]);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int xx = v.x + dir[i][0];
                int yy = v.y + dir[i][1];
                int zz = v.z + dir[i][2];
                if (xx < 0 || xx == n || yy < 0 || yy == n || zz < 0 || zz == n)
                    continue;
                if (stu[xx][yy][zz] != -1)
                    continue;
                if (a[xx][yy][zz] == '*')
                    continue;
                Q.add(new Node(xx, yy, zz));
                stu[xx][yy][zz] = stu[v.x][v.y][v.z] + 1;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        a = new char[n][n][n];
        stu = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = br.readLine().toCharArray();
                for (int j2 = 0; j2 < n; j2++) {
                    stu[i][j][j2] = -1;
                }
            }
        }
        bfs();
        if (flag)
            pw.println(-1);
        pw.flush();
    }
}
