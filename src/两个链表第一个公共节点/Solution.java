package 两个链表第一个公共节点;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 设两个链表长度为a,b
 * 两链表p1,p2，走完自己链表后将走另一个链表
 * 如果两个链表有交点
 * p1,p2在走到a+b时会相遇，即交点
 * 如果没交点，走完a+b后两者都为null
 * while(p1!=p2)保证，两者相等时退出循环，return p1或p2，有交点则return交点，没交点则return null
 */
public class Solution {
    //两节点走过a+b+c路程会在交点相遇
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}