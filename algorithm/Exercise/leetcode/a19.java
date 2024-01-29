package Exercise.leetcode;

public class a19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        int order = size - n;
        if (order == 0) {
            head = head.next;
            return head;
        }
        while (order-- > 1) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
