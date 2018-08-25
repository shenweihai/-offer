package 反转链表;

/**
 * 初始化pre、next指针为null
 * 1.保存next
 * 2.断开head.next,指向pre
 * 3.pre = head
 * 4.head = next
 *
 * 最后返回pre
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
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
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}