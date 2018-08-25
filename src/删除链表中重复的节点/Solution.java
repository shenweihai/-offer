package 删除链表中重复的节点;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 新建两个头结点
 * 当当前节点val等于下一节点val时，now = now.next，直到不等时，pre.next = now;
 * 当不相等时，pre = now,now = now.next
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        /*if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pre = new ListNode(-1);
        ListNode first = pre;
        pre.next = pHead;
        ListNode now = pHead;
        while (now != null && now.next != null) {
            if (now.val == now.next.val) {
                int val = now.val;
                while (now != null && now.val == val) {
                    now = now.next;
                }
                pre.next = now;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return first.next;*/
        if (pHead == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = pHead;
        ListNode p = pre;
        ListNode now = pHead;
        while (now != null && now.next != null) {
            if (now.val == now.next.val) {
                int val = now.val;
                while (now != null && now.val == val) {
                    now = now.next;
                }
                pre.next = now;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return p.next;
    }

    public static void main(String s[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        new Solution().deleteDuplication(node1);
    }

}