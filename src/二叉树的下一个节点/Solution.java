package 二叉树的下一个节点;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 1.如果有右子树，遍历右子树，返回最左节点
 * 2.如果没有右子树
 *   是父节点的左子树，返回父节点
 *   是父节点的右子树，p = p.parent，知道是左子树
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {//如果有右子树
            TreeLinkNode root = pNode.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                } else if (pNode.next.right == pNode) {
                    pNode = pNode.next;
                }
            }

        }
        return null;
    }
}