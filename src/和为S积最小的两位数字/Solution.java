package 和为S积最小的两位数字;

import java.util.ArrayList;

/**
 * 两个指针，low指向数组左边界，high指向数组右边界
 * 当a[i]+a[j]=sum，直接return
 * 当a[i]+a[j]>sum，high--
 * 当a[i]+a[j]<sum，low++
 * 回到low==high
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }
            if (array[i] + array[j] > sum) j--;
            else i++;
        }
        return list;
    }
}