package 连续子数组的最大和;

/**
 * 维持两个变量
 * sum保存当前和
 * max始终保存最大和
 * 是否该加上当前元素？判断sum+a[i]>a[i]
 * 是：  sum = sum+a[i]
 * 否：  sum = a[i]
 * 然后max = max(sum,max)
 *
 * return max
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum + array[i] > array[i] ? sum + array[i] : array[i];
            max = sum > max ? sum : max;
        }
        return max;
    }
}