package 判断是否平衡二叉搜索树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 求树的深度
 * 当左子树和右子树之差大于1时，return -1
 * 从左下开始递归，碰到-1，则不再递归，直接return -1
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}

