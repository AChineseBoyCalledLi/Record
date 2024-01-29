package homeworkForSecond;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.ArrayList;

public class Nov29 {
    public static void main(String[] args) {
        Map<Vertex, ArrayList<Vertex>> Graph = new HashMap<>();
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Vertex> neighbors = new ArrayList<>();
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');
        Vertex i = new Vertex('i');

        neighbors.add(b);
        neighbors.add(h);
        Graph.put(a, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(a);
        neighbors.add(h);
        neighbors.add(c);
        Graph.put(b, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(b);
        neighbors.add(i);
        neighbors.add(f);
        neighbors.add(d);
        Graph.put(c, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(c);
        neighbors.add(e);
        neighbors.add(f);
        Graph.put(d, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(d);
        neighbors.add(f);
        Graph.put(e, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(c);
        neighbors.add(d);
        neighbors.add(e);
        neighbors.add(g);
        Graph.put(f, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(f);
        neighbors.add(i);
        neighbors.add(h);
        Graph.put(g, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(i);
        neighbors.add(g);
        neighbors.add(a);
        neighbors.add(b);
        Graph.put(h, neighbors);

        neighbors = new ArrayList<>();
        neighbors.add(h);
        neighbors.add(g);
        neighbors.add(c);
        Graph.put(i, neighbors);

        edges.add(new Edge(a, h, 8));
        edges.add(new Edge(a, b, 4));
        edges.add(new Edge(h, b, 11));
        edges.add(new Edge(b, c, 8));
        edges.add(new Edge(c, i, 2));
        edges.add(new Edge(c, f, 4));
        edges.add(new Edge(c, d, 7));
        edges.add(new Edge(f, d, 14));
        edges.add(new Edge(d, e, 9));
        edges.add(new Edge(e, f, 10));
        edges.add(new Edge(f, g, 2));
        edges.add(new Edge(g, i, 6));
        edges.add(new Edge(g, h, 1));
        edges.add(new Edge(h, i, 7));

        // System.out.println(Kruskal(Graph, edges));
        Prim(Graph, edges, i);
        for (Vertex vertex : Graph.keySet()) {
            System.out.println(vertex);
        }
    }

    static void Prim(Map<Vertex, ArrayList<Vertex>> Graph, ArrayList<Edge> edges, Vertex r) {
        Map<Vertex, Map<Vertex, Integer>> nGraph = new HashMap<>();
        Map<Vertex, Integer> map = new HashMap<>();
        for (Vertex v : Graph.keySet()) {
            map = new HashMap<>();
            nGraph.put(v, map);
        }
        for (Edge edge : edges) {
            Vertex v1 = edge.v1;
            Vertex v2 = edge.v2;
            map = nGraph.get(v2);
            map.put(v1, edge.weight);
            nGraph.put(v2, map);
            map = nGraph.get(v1);
            map.put(v2, edge.weight);
            nGraph.put(v1, map);
        }
        // System.out.println(nGraph);
        r.d = 0;
        PriorityQueue<Vertex> Q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        for (Vertex vertex : Graph.keySet()) {
            Q.add(vertex);
        }
        System.out.println(Q);
        while (!Q.isEmpty()) {
            Vertex u = Q.peek();
            for (Vertex vertex : Graph.get(u)) {
                int d = nGraph.get(u).get(vertex);
                if (d < vertex.key && Q.contains(vertex)) {
                    vertex.prev = u;
                    vertex.d = d;
                    Q.poll();
                }
            }
        }
    }

    static ArrayList<Edge> Kruskal(Map<Vertex, ArrayList<Vertex>> Graph, ArrayList<Edge> edges) {
        ArrayList<Edge> path = new ArrayList<>();
        Map<Vertex, Set<Vertex>> set = new HashMap<>();
        Set<Vertex> s = new HashSet<>();

        for (Vertex vertex : Graph.keySet()) {
            s = new HashSet<>();
            s.add(vertex);
            set.put(vertex, s);
        }

        edges.sort((o1, o2) -> o1.weight - o2.weight);

        for (Edge e : edges) {
            Set<Vertex> s1 = set.get(e.v1);
            Set<Vertex> s2 = set.get(e.v2);
            if (s1 != s2) {
                path.add(e);
                s1.addAll(s2);
                for (Vertex vertex : s2) {
                    set.put(vertex, s1);
                }
            }
        }
        return path;
    }

}

class Vertex {
    char key;
    int d;
    Vertex prev;

    public Vertex(char key) {
        this.key = key;
        d = Integer.MAX_VALUE;
        prev = null;
    }

    public String toString() {
        return "" + key + " " + prev;
    }
}

class Edge {
    Vertex v1;
    Vertex v2;
    int weight;

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public String toString() {
        return v1 + "->" + v2;
    }

}
