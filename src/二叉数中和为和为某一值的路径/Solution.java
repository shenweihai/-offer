package 二叉数中和为和为某一值的路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 深度优先遍历
 * 1.当前节点为空，return null
 * 2.每次遍历当前路径path添加当前节点，target-val
 * 3.如果当前节点没有子节点且target==0，则加入总路径
 * 4.遍历左子树
 * 5.遍历右子树
 * 6.遍历完后path移除最后一个元素
 */
public class Solution {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return paths;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return paths;
    }

    public static void main(String[] args) {
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
        //new Solution().FindPath(node1, 10);
        ArrayList<ArrayList<Integer>> paths = new Solution().printAllPathback(node1);
        for (ArrayList<Integer> path : paths) {
            for (Integer o : path) {
                System.out.print(o + ",");
            }
            System.out.println();
        }
    }

    ArrayList printAllPath(TreeNode node) {
        if (node == null) {
            return null;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            //当前路径copy到paths
            paths.add(new ArrayList<>(path));
        }
        printAllPath(node.left);
        printAllPath(node.right);
        //遍历完这一层，去掉最后一个元素
        path.remove(path.size() - 1);
        return paths;
    }

    ArrayList<ArrayList> stacks = new ArrayList<>();
    ArrayList printAllPathback(TreeNode node) {
        if (node == null) {
            return null;
        }
        Stack<Integer> stack = null;
        printAllPathback(node.left);
        printAllPathback(node.right);
        if (node.left == null && node.right == null) {
            //当前路径copy到paths
            stack = new Stack<>();
        }
        stack.push(node.val);
        //遍历完这一层，去掉最后一个元素
        stacks.add(new ArrayList<>(stack));
        return paths;
    }
}