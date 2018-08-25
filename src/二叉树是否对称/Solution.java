package 二叉树是否对称;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 1.left==right都为null，return true
 * 2.left和right都不为null，return left.val == right.val && recursive(left.left, right.right) && recursive(left.right, right.left)
 * 3.return false
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return recursive(pRoot.left, pRoot.right);
    }

    boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && recursive(left.left, right.right) && recursive(left.right, right.left);
        }
        return false;
    }
}