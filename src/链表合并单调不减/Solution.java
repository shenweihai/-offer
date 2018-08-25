package 链表合并单调不减;

/**
 * 初始化两个指针head和current
 * 1.head和current赋值给第一个节点小的那个链表
 * 2.遍历两链表，谁大谁不动，谁小current指向谁，并且current=current.next
 * 3.小的p = p.next
 * 4.current.next指向非空p
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        ListNode current = null;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        while(list1!=null&&list2!=null){
           if(list1.val>=list2.val){
               if(head==null){
                   head = list2;
                   current = list2;
               }else{
                   current.next=list2;
                   current = current.next;
               }
               list2 = list2.next;
           }else{
               if(head==null){
                   head = list1;
                   current = list1;
               }else{
                   current.next = list1;
                   current = current.next;
               }
               list1 = list1.next;
           }
        }
        if(list1==null){
            current.next = list2;
        }
        else if(list2 ==null){
            current.next = list1;
        }
        return head;
    }
}
