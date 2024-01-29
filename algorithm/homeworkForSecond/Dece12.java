package homeworkForSecond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dece12 {
    public static void main(String[] args) {
        Map<Vertex, Map<Vertex, Integer>> G = new HashMap<>();
        Map<Vertex, Integer> neighbor = new HashMap<>();
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');
        Vertex z = new Vertex('z');
        neighbor.put(t, 10);
        neighbor.put(y, 5);
        G.put(s, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(y, 2);
        neighbor.put(x, 1);
        G.put(t, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(z, 4);
        G.put(x, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(t, 3);
        neighbor.put(x, 9);
        neighbor.put(z, 2);
        G.put(y, neighbor);
        neighbor = new HashMap<>();
        neighbor.put(s, 7);
        neighbor.put(x, 6);
        G.put(z, neighbor);
        shortest_path(G, s, t);
    }

    static void shortest_path(Map<Vertex, Map<Vertex, Integer>> G, Vertex s, Vertex e) {
        Dijkstra(G, s);
        Stack<Vertex> stack = findPar(e);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            System.out.print("->");
        }
        System.out.println(e);
    }

    static ArrayList<Vertex> Dijkstra(Map<Vertex, Map<Vertex, Integer>> G, Vertex s) {
        s.d = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        ArrayList<Vertex> S = new ArrayList<>();
        Q.addAll(G.keySet());
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            S.add(u);
            for (Map.Entry<Vertex, Integer> entry : G.get(u).entrySet()) {
                Vertex v = entry.getKey();
                int weight = entry.getValue();
                if (v.d > u.d + weight) {
                    v.d = u.d + weight;
                    v.pi = u;
                    Q.remove(v);
                    Q.add(v);
                }
            }
        }
        System.out.println(S);
        return S;
    }

    static Stack<Vertex> findPar(Vertex e) {
        Stack<Vertex> par = new Stack<>();
        while (e.pi != null) {
            par.add(e.pi);
            e = e.pi;
        }
        return par;
    }
}

class Vertex implements Comparable<Vertex> {
    char key;
    Vertex pi;
    int d;

    public Vertex(char key) {
        this.key = key;
        this.pi = null;
        this.d = Integer.MAX_VALUE;
    }

    public String toString() {
        return "" + key;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.d - o.d;
    }
}
