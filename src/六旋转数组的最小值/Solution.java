package 六旋转数组的最小值;

/**
 * 二分
 * 1.当array[mid]>array[high]
 *   最小元素在mid右边，low=mid+1
 * 2.当array[mid]<array[high]
 *   最小元素为mid或者在mid左边，high=mid
 * 3.当array[mid]==array[high]
 *   无法确定，只能让high--或者low++
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high = high - 1;
            }
        }
        return array[low];
    }
    /*public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int last = array[0];
        for (int i = 1; i < array.length; i++) {
            if (last > array[i]) {
                return array[i];
            }
            last = array[i];
        }
        return 0;
    }*/

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberInRotateArray(new int[]{23,0,0}));
    }
}