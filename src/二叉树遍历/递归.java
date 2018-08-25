package 二叉树遍历;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class 递归 {
    public static void main(String[] args) {
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
        preOrder(node1);
        System.out.println();
        midOrder(node1);
        System.out.println();
        postOrder(node1);
    }

    private static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + ",");
        }
    }

    private static void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            System.out.print(root.val + ",");
            midOrder(root.right);
        }
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
