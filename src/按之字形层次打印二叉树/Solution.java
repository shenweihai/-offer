package 按之字形层次打印二叉树;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 实例化一个奇数层和偶数层的栈，用来存放当前层次的节点
 * 奇数层从左至右，偶数层从右至左
 * pop完一个栈后，按顺序将子节点push到另外一个栈
 * 每pop完一层，添加到list
 * 知道两个栈都为空
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        /*ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(pRoot);
        int index = 0;
        //是否偶数层
        boolean flag = true;
        while (index < nodes.size()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = nodes.size();
            for (int i = size - 1; i >= index; i--) {
                TreeNode node = nodes.get(i);
                tmp.add(node.val);
                if (flag) {
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
            }
            index = size;
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
            result.add(tmp);
        }*/
        //奇数层
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        //偶数层
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        result.add(list);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode now = s1.pop();
                //偶数层，从右到左
                if (now.right != null) {
                    list1.add(now.right.val);
                    s2.push(now.right);
                }
                if (now.left != null) {
                    list1.add(now.left.val);
                    s2.push(now.left);
                }
            }
            if (!list1.isEmpty()) result.add(list1);
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode now = s2.pop();
                //奇数层，从左到右
                if (now.left != null) {
                    list2.add(now.left.val);
                    s1.add(now.left);
                }
                if (now.right != null) {
                    list2.add(now.right.val);
                    s1.add(now.right);
                }
            }
            if (!list2.isEmpty()) result.add(list2);
        }
        return result;
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