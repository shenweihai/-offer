package 深度广度搜索.有向图;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        char vertex[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        boolean visit[] = new boolean[7];
        Node[] nodeList = new Node[7];
        nodeList[0] = new Node(0, null);
        nodeList[1] = new Node(1, null);
        nodeList[2] = new Node(2, null);
        nodeList[3] = new Node(3, null);
        nodeList[4] = new Node(4, null);
        nodeList[5] = new Node(5, null);
        nodeList[6] = new Node(6, null);
        nodeList[0].next = new Node(1, null);
        nodeList[1].next = new Node(2, null);
        nodeList[1].next.next = new Node(4, null);
        nodeList[1].next.next.next = new Node(5, null);
        nodeList[2].next = new Node(4, null);
        nodeList[3].next = new Node(2, null);
        nodeList[4].next = new Node(1, null);
        nodeList[4].next.next = new Node(3, null);
        nodeList[5].next = new Node(6, null);
        nodeList[6].next = null;

        DFS(nodeList[0], nodeList, visit, vertex);
        System.out.println();
        BFS(nodeList[0], nodeList, vertex, new boolean[7]);
    }

    private static void BFS(Node first, Node[] nodeList, char[] vertex, boolean[] visit) {
        List<Integer> list = new ArrayList<>();
        list.add(first.index);
        int index = 0;
        visit[0] = true;
        while (list.size() > index) {
            int currentIndex = list.get(index);
            Node currentNode = nodeList[currentIndex];
            System.out.print(vertex[currentIndex] + " ");
            while ((currentNode = currentNode.next) != null) {
                if (!visit[currentNode.index]) {
                    list.add(currentNode.index);
                    visit[currentNode.index] = true;
                }
            }
            index++;
        }
    }

    private static void DFS(Node node, Node[] nodeList, boolean[] visit, char[] vertex) {
        System.out.print(vertex[node.index] + " ");
        visit[node.index] = true;

        while (node.next != null) {//先找链表的上的
            if (!visit[node.next.index]) {
                //从数组上递归
                DFS(nodeList[node.next.index], nodeList, visit, vertex);
            } else {//一直到往下，知道链表被找完
                node = node.next;
            }
        }
    }

}

class Node {
    int index;
    Node next;

    public Node(int index, Node next) {
        this.index = index;
        this.next = next;
    }
}