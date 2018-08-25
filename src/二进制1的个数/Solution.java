package 二进制1的个数;

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            //从最右边的1开始，1变成0,0变成1
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
