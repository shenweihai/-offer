package 矩阵中的路径_回溯;

/**
 * 每个节点都当做起始点进行递归回溯
 * 当找到路径后直接return 不在循环下去
 * 用一个visit数组表示节点是否被访问
 * 递归：
 * 先判断字符串有没有被匹配完，匹配完直接return true
 * 在判断matrix有没有越界||当前节点有没有被访问||两个字符是否匹配
 * flag[i]=true；将节点标记为已访问
 * return 向上走一步||向下走一步||向左走一步||向右走一步
 * flag[i]=false；没有匹配到，则回溯到上一步，将节点恢复为未访问
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || str.length == 0 || str.length > matrix.length || rows * cols > matrix.length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                boolean[] flag = new boolean[matrix.length];
                if (recursive(matrix, rows, cols, str, i, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recursive(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] flag) {
        if (j > str.length - 1) {
            return true;
        }
        if (i > matrix.length - 1 || i < 0 || flag[i] || matrix[i] != str[j]) {
            return false;
        }
        flag[i] = true;
        boolean result = recursive(matrix, rows, cols, str, i + 1, j + 1, flag) || recursive(matrix, rows, cols, str, i + cols, j + 1, flag) ||
                recursive(matrix, rows, cols, str, i - 1, j + 1, flag) || recursive(matrix, rows, cols, str, i - cols, j + 1, flag);
        flag[i] = false;
        return result;
    }

    public static void main(String s[]) {
        new Solution().hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray());
    }
}