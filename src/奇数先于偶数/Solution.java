package 奇数先于偶数;

/**
 * 计算奇数个数
 * 新建一个数组，维持两个指针，一个指向奇数，一个指向偶数
 * 遍历元素组，分别将奇数和偶数赋给新数组
 */
public class Solution {
    public void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }
        int oddCount = 0;
        int oddbegin = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[oddbegin++] = array[i];//奇数
            } else {
                newArray[oddCount++] = array[i];//偶数
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
