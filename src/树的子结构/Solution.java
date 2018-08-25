package 树的子结构;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 *
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        //从根节点开始匹配||从左子树开始匹配||从右子树开始匹配
        return subHasSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean subHasSubtree(TreeNode root1, TreeNode root2) {
        //root2遍历完，证明root2是root1的子结构
        if (root2 == null) return true;
        //root2没完，root1完了，证明root2不是root1的子结构
        if (root1 == null) return false;
        //相等则递归判断左子树和右子树
        if (root1.val == root2.val)
            return subHasSubtree(root1.left, root2.left) && subHasSubtree(root1.right, root2.right);
        //有一个不相等则return false
        return false;
    }
}