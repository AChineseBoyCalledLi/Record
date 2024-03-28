import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class a5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static StreamTokenizer st = new StreamTokenizer(br);

    static int nextInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        int m = nextInt();
        Map<Node, Set<Node>> map = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            Set<Node> set;
            Node t = new Node(nextInt(), -1);
            if (map.get(t) == null) {
                set = new HashSet<>();
            } else {
                set = map.get(t);
            }
            set.add(new Node(nextInt(), -1));
            map.put(t, set);
        }
        Map<Node, Set<Node>> mapT = new LinkedHashMap<>();
        for (Node node : map.keySet()) {
            for (Node node1 : map.get(node)) {
                Set<Node> set;
                if (mapT.containsKey(node1)) {
                    set = new HashSet<>();
                } else {
                    set = mapT.get(node1);
                }
                set.add(node);
                mapT.put(node1, set);
            }
        }
        Node s = new Node(nextInt(), 1);
        Node t = new Node(nextInt(), -1);
        
    }

    static class Node {
        int x;
        int val;
        int cnt;

        public Node(int x, int val) {
            this.x = x;
            this.val = val;
            cnt = 0;
        }

        @Override
        public boolean equals(Object obj) {
            Node o = (Node) obj;
            return this.x == o.x;
        }

    }
}
