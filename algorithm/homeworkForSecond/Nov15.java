package homeworkForSecond;

import java.awt.Color;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Nov15 {
    public static void main(String[] args) {
        Vertex<Character, Integer> a = new Vertex<>('a');
        Vertex<Character, Integer> b = new Vertex<>('b');
        Vertex<Character, Integer> c = new Vertex<>('c');
        Vertex<Character, Integer> d = new Vertex<>('d');
        Vertex<Character, Integer> e = new Vertex<>('e');
        Vertex<Character, Integer> f = new Vertex<>('f');
        Vertex<Character, Integer> g = new Vertex<>('g');
        Vertex<Character, Integer> h = new Vertex<>('h');
        Vertex<Character, Integer> i = new Vertex<>('i');

        Graph<Character, Integer> graph = new Graph<>();
        graph.addEdgesUndirected(a, b, 4);
        graph.addEdgesUndirected(a, h, 8);
        graph.addEdgesUndirected(b, h, 11);
        graph.addEdgesUndirected(b, c, 8);
        graph.addEdgesUndirected(h, i, 7);
        graph.addEdgesUndirected(h, g, 1);
        graph.addEdgesUndirected(i, c, 2);
        graph.addEdgesUndirected(i, g, 6);
        graph.addEdgesUndirected(c, f, 4);
        graph.addEdgesUndirected(c, d, 7);
        graph.addEdgesUndirected(g, f, 2);
        graph.addEdgesUndirected(d, f, 14);
        graph.addEdgesUndirected(d, e, 9);
        graph.addEdgesUndirected(f, e, 10);
        System.out.println(graph.mstKruskal());
        // System.out.println(graph.maps);
    }
}

@SuppressWarnings("unchecked")
class Edge<T, E> implements Comparable<Edge<T, E>> {
    E weight;
    Vertex<T, E> v1;
    Vertex<T, E> v2;

    public Edge(Vertex<T, E> v1, Vertex<T, E> v2, E weight) {
        this.weight = weight;
        this.v1 = v1;
        this.v2 = v2;
    }

    // public Edge(Vertex<T, E> v1, Vertex<T, E> v2) {
    // this.v1 = v1;
    // this.v2 = v2;
    // }

    public int compareTo(Edge<T, E> o) {
        return ((Comparable<E>) this.weight).compareTo(o.weight);
    }

    public String toString() {
        return v1 + "<____>" + v2;
    }
}

@SuppressWarnings("unchecked")
class Vertex<T, E> implements Comparable<Vertex<T, E>> {
    T key;
    Color c;
    int d;
    Vertex<T, E> pi;
    ArrayList<Vertex<T, E>> neighbour;
    int time;

    public Vertex(T key) {
        this.key = key;
        c = Color.white;
        d = Integer.MAX_VALUE;
        pi = null;
        neighbour = new ArrayList<>();
        time = Integer.MAX_VALUE;
    }

    public void addNeighbour(Vertex<T, E> v) {
        if (neighbour.contains(v))
            return;
        neighbour.add(v);
        v.neighbour.add(this);// 这样是双向的，这句话不写上去就是单向的。
    }

    public String toString() {
        return key.toString();
    }

    public int compareTo(Vertex<T, E> o) {
        return ((Comparable<T>) key).compareTo(o.key);
    }
}

@SuppressWarnings("unchecked")
// 这个图在添加点之前点的邻边都要添加好
class Graph<T, E> {
    ArrayList<Edge<T, E>> edges;
    Set<Vertex<T, E>> Vertices;
    TreeMap<Vertex<T, E>, ArrayList<Vertex<T, E>>> maps;

    public Graph() {
        maps = new TreeMap<>();
        edges = new ArrayList<>();
        Vertices = new TreeSet<>();
    }

    public void addVertex(Vertex<T, E> v) {
        maps.put(v, v.neighbour);
        Vertices.add(v);
    }

    public void addEdgesUndirected(Vertex<T, E> v1, Vertex<T, E> v2, E weight) {
        v1.addNeighbour(v2);
        if (!Vertices.contains(v1))
            addVertex(v1);
        if (!Vertices.contains(v2))
            addVertex(v2);
        Edge<T, E> edge = new Edge<>(v1, v2, weight);
        edges.add(edge);
    }

    public Edge<T, E> findEdge(Vertex<T, E> v1, Vertex<T, E> v2) {
        for (Edge<T, E> e : edges) {
            if (e.v1 == v1 && e.v2 == v2 || e.v1 == v2 && e.v2 == v1) {
                return e;
            }
        }
        return null;
    }

    public void bfs(Vertex<T, E> s) {
        reset();
        s.c = Color.gray;
        s.d = 0;
        Queue<Vertex<T, E>> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            Vertex<T, E> v = queue.poll();
            System.out.println(v);
            for (Vertex<T, E> vertex : v.neighbour) {
                if (vertex.c == Color.white) {
                    vertex.c = Color.gray;
                    vertex.d = 1 + v.d;
                    vertex.pi = v;
                    queue.add(vertex);
                }
            }
            v.c = Color.black;
        }
    }

    public ArrayList<Vertex<T, E>> ShortestPath(Vertex<T, E> start, Vertex<T, E> end) {
        reset();
        ArrayList<Vertex<T, E>> path = new ArrayList<>();
        bfs(start);
        while (end.pi != null) {
            path.add(end.pi);
            end = end.pi;
        }
        return path;
    }

    public void dfs(Vertex<T, E> s) {// 拓扑排序用栈做不方便，记录不了时间，用递归更方便//思考一下用栈怎么实现记录完成的时间
        // 如果用递归怎么实现拓扑排序
        reset();
        Stack<Vertex<T, E>> stack = new Stack<>();
        s.c = Color.gray;
        s.d = 0;
        stack.push(s);
        while (!stack.isEmpty()) {
            Vertex<T, E> v = stack.pop();
            System.out.println(v);
            for (Vertex<T, E> vertex : v.neighbour) {
                if (vertex.c == Color.white) {
                    vertex.c = Color.gray;
                    vertex.d = v.d + 1;
                    vertex.pi = v;
                    stack.push(vertex);
                }
            }
            v.c = Color.black;
        }
    }

    public void reset() {
        for (Vertex<T, E> vertex : Vertices) {
            vertex.c = Color.white;
            vertex.d = Integer.MAX_VALUE;
            vertex.pi = null;
            vertex.time = Integer.MAX_VALUE;
        }
    }

    public void transpose() {
        for (Vertex<T, E> vertex : Vertices) {
            vertex.neighbour = new ArrayList<>();
        }
        for (Map.Entry<Vertex<T, E>, ArrayList<Vertex<T, E>>> entry : this.maps.entrySet()) {
            Vertex<T, E> neighbor = entry.getKey();
            for (Vertex<T, E> v : entry.getValue()) {
                v.addNeighbour(neighbor);
            }
        }
        for (Vertex<T, E> vertex : Vertices) {
            maps.put(vertex, vertex.neighbour);
        }
    }

    /*
     * @ Strongly connected components
     */
    public void scc() {
        transpose();
    }

    public ArrayList<Edge<T, E>> mstKruskal() {
        ArrayList<Edge<T, E>> path = new ArrayList<>();
        Map<Vertex<T, E>, Set<Vertex<T, E>>> v_S = new HashMap<>();
        Set<Vertex<T, E>> set = new TreeSet<>();
        for (Vertex<T, E> vertex : Vertices) {
            set = new TreeSet<>();
            set.add(vertex);
            v_S.put(vertex, set);
        }

        edges.sort((e1, e2) -> ((Comparable<E>) e1.weight).compareTo(e2.weight));
        for (Edge<T, E> e : edges) {
            Set<Vertex<T, E>> s1 = v_S.get(e.v1);
            Set<Vertex<T, E>> s2 = v_S.get(e.v2);
            if (!s1.equals(s2)) {
                path.add(e);
                s1.addAll(s2);
                for (Vertex<T, E> vertex : s2) {
                    v_S.put(vertex, s1);
                }
                // s2 = s1;
                // s2.addAll(s1);
                // for (Vertex<T, E> vertex : s1) {
                // v_S.remove(vertex);
                // v_S.put(vertex, s1);
                // }
            }
        }
        return path;
    }

    public void prim(Vertex<T, E> s) {
        // for (Vertex<T, E> vertex : Vertices) {
        // vertex.d = Integer.MAX_VALUE;
        // vertex.pi = null;
        // }
        s.d = 0;
        s.pi = null;
        PriorityQueue<Vertex<T, E>> Q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        for (Vertex<T, E> vertex : Vertices) {
            Q.add(vertex);
        }
        while (!Q.isEmpty()) {
            Vertex<T, E> v = Q.poll();
            for (Vertex<T, E> vertex : v.neighbour) {
                if ((Integer) findEdge(v, vertex).weight < vertex.d) {
                    vertex.pi = v;
                    vertex.d = (Integer) findEdge(v, vertex).weight;
                    Q.remove(vertex);
                    Q.add(vertex);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Graph [edges=" + edges + "]";
    }
}
