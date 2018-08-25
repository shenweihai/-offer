package 四重建二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
public class double的整数次方 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = null;
        for (int i = 0; i <= in.length; i++) {
            if (pre[0] == in[i]) {
                root = new TreeNode(pre[0]);
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
*/

/**
 * 1.前序数组的第一位总是根节点
 * 2.中序数组找到该节点，并将数组分割成两段
 * 3.前序也按照中序的长度分割成两段
 * 4.创建根节点，左子树等于build(前序左子数组，中序左子数组)
 * 5.右子树等于build(前序右子数组，中序右子数组)
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode build(int pre[], int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = null;
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root = new TreeNode(pre[startPre]);
                root.left = build(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = build(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
