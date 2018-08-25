package 二叉搜索树转换为双向链表_中序遍历;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

/**
 * 中序遍历
 * 初始化head节点和pre节点
 * 找到最左节点，赋为head和pre(上一节点)
 * pre.right=root
 * root.left=pre
 * pre=root
 */

public class Solution {

    /**
     * 纯中序遍历，二叉搜索树从小到大排序
     */
    private TreeNode head, pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        minScan(pRootOfTree);
        return head;
    }

    public void minScan(TreeNode root) {
        if (root == null) return;
        minScan(root.left);
        if (head == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        minScan(root.right);
    }
}