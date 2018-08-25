package 二叉树深度;

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
 * 数的深度=max(左子树深度，右子树深度)+1
 * 递归+1，当前节点为null时，返回0
 */

/**
 * 非递归版
 * 用队列保存上一层节点
 *
 * while(!list.isEmpty())
 *  length++（每处理一层深度+1）
 *  while (size-- != 0)
 *      pop
 *      offer左节点
 *      offer右节点
 */
public class Solution {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
    public int TreeDepthUnRecursively(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        int length = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            length++;
            while (size-- != 0) {
                TreeNode node = list.pop();
                if (node.left != null) list.offer(node.left);
                if (node.right != null) list.offer(node.right);
            }
        }
        return length;
    }
}