package Exercise.蓝桥;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class a1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int citys = scan.nextInt();
        int edges = scan.nextInt();
        int inf = scan.nextInt();
        Map<Integer, Vertex> Vertices = new HashMap<>();
        for (int i = 1; i < citys + 1; i++) {
            Vertices.put(i, new Vertex(i));
        }
        Map<Integer, Map<Vertex, Vertex>> E = new HashMap<>();
        Map<Vertex, Map<Vertex, Integer>> maps = new HashMap<>();
        Map<Vertex, Integer> road;
        for (int i = 1; i < edges + 1; i++) {
            Vertex v = Vertices.get(scan.nextInt());
            road = maps.get(v);
            if (road == null)
                road = new HashMap<>();
            Vertex u = Vertices.get(scan.nextInt());
            road.put(u, scan.nextInt());
            maps.put(v, road);
            Map<Vertex, Vertex> e = new HashMap<>();
            e.put(v, u);
            E.put(i, e);
        }
        for (int i = 0; i < inf; i++) {
            Vertex v = null;
            Vertex u = null;
            Map<Vertex, Vertex> e = E.get(scan.nextInt());
            for (Vertex vertex : e.keySet()) {
                v = vertex;
                u = e.get(v);
            }
            road = maps.get(v);
            road.put(u, scan.nextInt());
            maps.put(v, road);
            Prim(maps, Vertices.get(1));
            int sum = 0;
            for (Vertex vt : Vertices.values()) {
                sum += vt.d;
            }
            System.out.println(sum);
        }
        scan.close();
    }

    static void Prim(Map<Vertex, Map<Vertex, Integer>> maps, Vertex s) {
        s.d = 0;
        s.flag = false;
        PriorityQueue<Vertex> Q = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
        Q.addAll(maps.keySet());
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            for (Vertex vertex : maps.get(u).keySet()) {
                int d = maps.get(u).get(vertex);
                if (Q.contains(vertex) && vertex.d > d) {
                    vertex.d = d;
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
    }

    static class Vertex {
        int key;
        int d;
        Boolean flag;

        public Vertex(int key) {
            this.key = key;
            flag = true;
            d = Integer.MAX_VALUE;
        }
    }
}
