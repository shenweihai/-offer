package 数组中只出现一次的数字;

/**
 * 所有元素相与，得出s
 * 找出s的第一个1，得到flag（为什么选1，因为为了找出不同两个，把他们分到不同组）
 * 所有元素和flag相与，等于0和等于1分成两组，组内相与就是两个数
 */
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int s = 0;
        //所有元素异或
        for (int i : array) {
            s ^= i;
        }
        //从右往左找到第一个1
        int flag = 1;
        while ((s & flag) != flag) {
            flag <<= 1;
        }
        for (int i : array) {
            if ((i & flag) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}