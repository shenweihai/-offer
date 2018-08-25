package 复杂链表的复制;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    /*
    *解题思路：
    *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
    *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
    *3、拆分链表，将链表拆分为原链表和复制后的链表
    */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode next = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = next;
            currentNode = cloneNode.next;
        }

        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        RandomListNode cloneHead = pHead.next;
        currentNode = pHead;
        while (currentNode != null) {
            RandomListNode next = currentNode.next;
            currentNode.next = currentNode.next == null ? null : currentNode.next.next;
            currentNode = next;
        }
        return cloneHead;
    }
}