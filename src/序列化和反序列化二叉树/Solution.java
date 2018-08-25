package 序列化和反序列化二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 1.序列化
 * 中序遍历递归
 * 当前节点为null，append #,
 * 当前节点不为null，append val,
 * 2.反序列化
 * index表示当前偏移
 * 当前节点是否为#
 * 是则return
 * 否则new Node，node.left=递归,node.right=递归
 */
public class Solution {
    StringBuilder sb = new StringBuilder();
    int index = -1;

    String Serialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return null;
        } else {
            sb.append(root.val + ",");
        }
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        String[] array = str.split(",");
        return recursive(array);
    }

    TreeNode recursive(String[] str) {
        if (index == str.length) {
            return null;
        }
        index++;
        TreeNode node = null;
        if (!"#".equals(str[index])) {
            node = new TreeNode(Integer.parseInt(str[index]));
            node.left = recursive(str);
            node.right = recursive(str);
        }
        return node;
    }


    public static void main(String s[]) {
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
        System.out.println(new Solution().Serialize(node1));
        new Solution().Deserialize("8,10,5,#,#,7,#,#,6,9,#,#,11,#,#,");
    }
}