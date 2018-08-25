package 从1加到n不适用乘除法和循环分支;

/**
 * 用递归来计算1+...+n
 * 停止条件用n>0&&
 */
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n - 1) >= 0 && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
