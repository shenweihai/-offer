package 机器人运动_回溯;

/**
 * 实例化visit数组保存节点访问状态
 * 递归：
 * 当前下标是否越界||节点是否已被访问||下标之和是否大于阈值 ，return 0
 * 将当前元素标记为已访问
 * return 向上走一步||向下走一步||向左走一步||向右走一步 +1（每次调用都会+1，即当前符合条件就会+1）
 * 直到递归完成
 */
public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 && cols < 0) {
            return 0;
        }
        boolean flag[][] = new boolean[rows][cols];
        return recursive(threshold, 0, 0, rows, cols, flag);
    }

    private int recursive(int threshold, int i, int j, int rows, int cols, boolean[][] flag) {
        if (i >= rows || i < 0 || j < 0 || j >= cols || flag[i][j] || (getSum(i) + getSum(j)) > threshold) {
            return 0;
        }
        flag[i][j] = true;
        //每掉一次，返回值+1
        return recursive(threshold, i + 1, j, rows, cols, flag) + recursive(threshold, i, j + 1, rows, cols, flag) +
                recursive(threshold, i - 1, j, rows, cols, flag) + recursive(threshold, i, j - 1, rows, cols, flag) + 1;
    }

    private int getSum(int i) {
        int sum = i % 10;
        while ((i = i / 10) > 0) {
            sum += i % 10;
        }
        return sum;
    }

    public static void main(String s[]) {
        System.out.println(new Solution().movingCount(6, 4, 4));
    }
}