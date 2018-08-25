package 求等差数列和不用关键字;

public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum = sum + Sum_Solution(n - 1)) > 0;
        return sum;
    }
}