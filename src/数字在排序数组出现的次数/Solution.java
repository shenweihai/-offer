package 数字在排序数组出现的次数;

/**
 * 欲求目标K的个数，则需要求K的左边界和右边界下标之差
 * 转换成求 K+0.5 与 K-0.5的下标之差
 * 利用二分搜索，返回目标值的左下标或者右下标
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        return binarySearch(array, 0, array.length - 1, k + .05) - binarySearch(array, 0, array.length - 1, k - .05);
    }

    public int binarySearch(int[] array, int left, int right, double k) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (k == array[mid]) return mid;
            if (k < array[mid]) right = mid - 1;
            if (k > array[mid]) left = mid + 1;
        }
        return right;
    }
}