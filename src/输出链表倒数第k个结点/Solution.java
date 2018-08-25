package 输出链表倒数第k个结点;


/**
 * 当before链表先走第k-1步
 * behind在开始走
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode before = head, behind = head;
        int i = 0;
        for (; before.next != null; i++) {
            if (i >= k - 1) {
                behind = behind.next;
            }
            before = before.next;
        }
        return i < k - 1 ? null : behind;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
