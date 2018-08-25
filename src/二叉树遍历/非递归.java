package 二叉树遍历;

import java.util.Stack;

public class 非递归 {
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
        System.out.println();
    }

    private static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode last = root;
        while (!stack.isEmpty()) {
            root = stack.peek();
            if ((root.left == null && root.right == null) || (root.left == null && root.right == last) || last == root.right) {
                System.out.print(root.val + ",");
                last = root;
                stack.pop();
            } else {
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    private static void midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + ",");
                root = root.right;
            }
        }
    }

    private static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print(root.val + ",");
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }
}
