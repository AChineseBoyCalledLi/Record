package homeworkForSecond;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.awt.Color;

public class Nov22 {
    static int time;

    public static void main(String[] args) {
        Map<Vertex<Character>, ArrayList<Vertex<Character>>> G = new TreeMap<>();
        ArrayList<Vertex<Character>> scc = new ArrayList<>();
        Vertex<Character> a = new Vertex<>('a');
        Vertex<Character> b = new Vertex<>('b');
        Vertex<Character> c = new Vertex<>('c');
        Vertex<Character> d = new Vertex<>('d');
        Vertex<Character> e = new Vertex<>('e');
        Vertex<Character> f = new Vertex<>('f');
        Vertex<Character> g = new Vertex<>('g');
        Vertex<Character> h = new Vertex<>('h');
        a.addNeighbor(b);
        b.addNeighbor(e);
        b.addNeighbor(c);
        c.addNeighbor(d);
        c.addNeighbor(g);
        d.addNeighbor(c);
        d.addNeighbor(h);
        h.addNeighbor(h);
        e.addNeighbor(a);
        e.addNeighbor(f);
        f.addNeighbor(g);
        g.addNeighbor(f);
        g.addNeighbor(h);

        G.put(a, a.neighbor);
        G.put(b, b.neighbor);
        G.put(c, c.neighbor);
        G.put(d, d.neighbor);
        G.put(e, e.neighbor);
        G.put(f, f.neighbor);
        G.put(g, g.neighbor);
        G.put(h, h.neighbor);

        dfs(G, scc);
        System.out.println(scc);
        scc(G);
    }

    static void dfs(Map<Vertex<Character>, ArrayList<Vertex<Character>>> G, ArrayList<Vertex<Character>> order) {
        for (Map.Entry<Vertex<Character>, ArrayList<Vertex<Character>>> entry : G.entrySet()) {
            entry.getKey().c = Color.white;
            entry.getKey().times = Integer.MAX_VALUE;
        }
        time = 0;
        if (order.size() == 0) {
            for (Map.Entry<Vertex<Character>, ArrayList<Vertex<Character>>> entry : G.entrySet()) {
                if (entry.getKey().c == Color.white) {
                    dfs_visit(G, entry.getKey(), order);
                }
            }
        } else {
            for (Vertex<Character> vertex : order) {
                if (vertex.c == Color.white) {
                    System.out.print("SCC is");
                    dfs_visit(G, vertex, order);
                    System.out.println();
                }

            }
        }
    }

    static void dfs_visit(Map<Vertex<Character>, ArrayList<Vertex<Character>>> G, Vertex<Character> v,
            ArrayList<Vertex<Character>> ret) {
        time++;
        if (ret.size() == G.size())
            System.out.print(" " + v);
        else {
            ret.add(v);
        }
        v.c = Color.black;

        for (Vertex<Character> vertex : v.neighbor) {
            if (vertex.c == Color.white) {
                dfs_visit(G, vertex, ret);
            }
        }
        v.times = ++time;

    }

    static void scc(Map<Vertex<Character>, ArrayList<Vertex<Character>>> G) {
        ArrayList<Vertex<Character>> order = new ArrayList<>();
        dfs(G, order);
        Map<Vertex<Character>, ArrayList<Vertex<Character>>> GT = transpose(G);
        order.sort((o1, o2) -> o2.times - o1.times);
        dfs(GT, order);
    }

    static Map<Vertex<Character>, ArrayList<Vertex<Character>>> transpose(
            Map<Vertex<Character>, ArrayList<Vertex<Character>>> G) {
        Map<Vertex<Character>, ArrayList<Vertex<Character>>> GT = new TreeMap<>();
        for (Map.Entry<Vertex<Character>, ArrayList<Vertex<Character>>> entry : G.entrySet()) {
            entry.getKey().neighbor = new ArrayList<>();
        }
        for (Map.Entry<Vertex<Character>, ArrayList<Vertex<Character>>> entry : G.entrySet()) {
            Vertex<Character> key = entry.getKey();
            key.c = Color.white;
            for (Vertex<Character> v : entry.getValue()) {
                v.c = Color.white;
                v.neighbor.add(key);
            }
        }
        for (Map.Entry<Vertex<Character>, ArrayList<Vertex<Character>>> entry : G.entrySet()) {
            GT.put(entry.getKey(), entry.getKey().neighbor);
        }
        return GT;
    }
}

@SuppressWarnings("unchecked")
class Vertex<T> implements Comparable<Vertex<T>> {
    ArrayList<Vertex<T>> neighbor;
    T key;
    int times;
    Color c;

    public Vertex(T key) {
        neighbor = new ArrayList<>();
        c = Color.white;
        this.key = key;
    }

    public void addNeighbor(Vertex<T> v) {// 单向
        neighbor.add(v);
    }

    public String toString() {
        return key.toString();
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return ((Comparable<T>) this.key).compareTo(o.key);
    }

}
