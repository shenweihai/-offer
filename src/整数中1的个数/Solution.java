package 整数中1的个数;

/**
 * a=n/i,b=n%i,i为1,10，100位数
 * 三种情况
 * 1.第i位>1，count = (a/10+1)*i
 * 2.第i位=1，count = (a/10)*i+ b+1
 * 3.第i位<1，count = (a/10)*i
 * i<=1时，(a+8)/10=(a/10)
 * i>1时，(a+8)/10=(a/10+1)
 * count += (a+8)/10*i + (a%i==1?b+1:0)
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i = i * 10) {
            int a = n / i;
            int b = n % i;
            count += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }
}