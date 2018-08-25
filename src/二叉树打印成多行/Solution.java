package 二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 用一个队列来保存当前层的节点
 * 将上一层的节点全部弹出
 * 然后将子节点按顺序压到队列
 * 直到队列为空
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        while (!list.isEmpty()) {
            int size = list.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = list.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    list.offer(node.left);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
            }
            result.add(tmp);
        }
        return result;
       /* nodes.add(pRoot);
        int index = 0;
        int level = 0;
        int count = 0;
        ArrayList<Integer> tmp = new ArrayList();
        while (index <= nodes.size() - 1) {
            TreeNode now = nodes.get(index);
            if (now.left != null) {
                nodes.add(now.left);
                count++;
            }
            if (now.right != null) {
                nodes.add(now.right);
                count++;
            }
            tmp.add(nodes.get(index).val);
            if (index == level) {
                level += count;
                count = 0;
                result.add(tmp);
                tmp = new ArrayList<>();
            }
            index++;
        }
        return result;*/
    }

    public static void main(String s[]) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.right = node2;
        node1.left = node3;
        node2.left = node6;
        node2.right = node7;
        node3.left = node4;
        node3.right = node5;
        new Solution().Print(node1);
    }
}
