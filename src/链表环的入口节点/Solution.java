package 链表环的入口节点;

/**
 * 快指针每次移动两步
 * 快指针和慢指针相遇时
 * 快指针路程:a+b+(n+1)(b+c)
 * 慢指针路程:a+b+n(b+c)
 * 快=2*慢
 * 得到a=x(b+c)+c即a=x个环+c
 * 让慢指针指向头，一步一步走，走a个长度
 * 快指针不变，一步一步走，走x个环+c
 * 两者必在a相遇，即两者指针相遇时返回
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = pHead;
                //相等则代表slow和fast已经相遇，包括在pHead位置相遇
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}