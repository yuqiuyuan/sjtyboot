package leeCode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        int q = 0;
        ListNode qNode = head;
        ListNode rmNode = head;
        while (qNode.next != null) {
            qNode = qNode.next;
            q++;
            if (q > n) {
                rmNode = rmNode.next;
            }
        }
        if (++q == 2 && n == 1) {
            head.next = null;
        } else if (q == 2 && n == 2) {
            head = head.next;
        } else if (q - n >= 1) {
            rmNode.next = rmNode.next.next;
        } else {
            return head.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
