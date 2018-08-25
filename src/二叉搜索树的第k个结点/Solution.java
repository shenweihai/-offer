package 二叉搜索树的第k个结点;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 中序遍历的第k个元素正好是第k小的元素
 * 中序遍历递归，index记录当前元素位置
 * 当index==k时，return node
 */
public class Solution {
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        /*if (pRoot != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null) return left;
            if (++index == k) return pRoot;
            TreeNode right = KthNode(pRoot.right, k);
            if (right != null) return right;
        }
        return null;*/
        if (pRoot == null) return null;
        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) return node;
        if (++index == k) return pRoot;
        node = KthNode(pRoot.right, k);
        if (node != null) return node;
        return null;
    }

    public static void main(String s[]) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(new Solution().KthNode(node1, 3).val);
    }
}