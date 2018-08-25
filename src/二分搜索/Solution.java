package 二分搜索;

public class Solution {
    public int binarySearch(int[] array, int left, int right, double k) {
        if (left <= right) {
            int mid = (left + right) >> 1;
            if (k == array[mid]) return mid;
            if (array[mid] > k) return binarySearch(array, left, mid - 1, k);
            if (array[mid] < k) return binarySearch(array, mid + 1, right, k);
        }
        return -1;
    }

    public static void main(String s[]) {
        int a[] = {0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(new Solution().binarySearch(a, 0, a.length - 1, 2));
    }
}
