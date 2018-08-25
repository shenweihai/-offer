package 二叉树层次遍历;

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 初始化一个index指针，指向当前节点
 * 初始化一个列表，存放当前节点
 * 先添加root节点
 * 遍历列表，添加当前节点的左孩子和右孩子
 * 直到index超出列表范围
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        nodes.add(root);
        int index = 0;
        while (index < nodes.size() && (root = nodes.get(index++)) != null) {
            result.add(root.val);
            if (root.left != null) {
                nodes.add(root.left);
            }
            if (root.right != null) {
                nodes.add(root.right);
            }
        }
        return result;
    }
}