package Exercise.洛谷;

import java.util.Scanner;

public class p1996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node head = new Node(1);
        Node node = head;
        for (int i = 2; i <= n; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        node.next = head;
        StringBuffer sb = new StringBuffer();

        while (node.next != node) {
            for (int i = 1; i < m; i++) {
                node = node.next;
            }
            sb.append(node.next.value).append(' ');
            node.next = node.next.next;
        }
        sb.append(node.value);
        System.out.println(sb);
        sc.close();
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
