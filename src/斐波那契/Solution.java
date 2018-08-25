package 斐波那契;

public class Solution {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prePre = 0;
        int pre = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = pre + prePre;
            prePre = pre;
            pre = sum;
        }
        return sum;
    }
}
