package 求数组峰值;

public class Solution {
    public int getPeak(int array[]) {
        int low = 0;
        int high = array.length - 1;
        if (array == null || array.length == 0) {
            return -1;
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            if (array[mid] > array[mid + 1]) {
                high = mid;
            } else if (array[mid] < array[mid + 1]) {
                low = mid + 1;
            } else {
                low++;
                //high--;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPeak(new int[]{1,2,3,3,3,55,2,1}));
        System.out.println(solution.getPeak(new int[]{1,2,3,4,5,5,6,6,3,1}));
        System.out.println(solution.getPeak(new int[]{1,2,3,4,5}));
        System.out.println(solution.getPeak(new int[]{1,30,3,3,3,3}));
    }
}
