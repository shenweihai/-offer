package 二分搜索;

public class Solution2 {
    public int binarySearch(int[] array, int left, int right, double k) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] == k) return mid;
            if (array[mid] < k) left = mid + 1;
            if (array[mid] > k) right = mid - 1;
        }
        return left;
    }

    public static void main(String s[]) {
        int a[] = {1,2,2,2,3,4};
        System.out.println(new Solution2().binarySearch(a, 0, a.length - 1, 2.5));
    }
}
