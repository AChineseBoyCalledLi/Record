package Exercise.leetcode;


public class a92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1);
        ListNode nil = pre;
        pre.next = head;
        ListNode start = head;
        ListNode end = head;
        for (int i = 1; i < left; i++) {
            pre = start;
            start = start.next;
        }
        for (int i = 1; i < right; i++) {
            end = end.next;
        }
        ListNode next = end.next;
        end.next = null;
        reverse(start);
        pre.next = end;
        start.next = next;
        return nil.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
