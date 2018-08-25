package 一二维数组的查找;


/**
 * 矩阵的最顶点
 * 比上面的元素都小
 * 比右边的元素都大
 * 让目标元素从左顶点开始比较，小于当前元素则上移，大于当前元素则右移
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                j++;
                continue;
            }
            if (array[i][j] > target) {
                i--;
                continue;
            }
            return false;
        }
        return false;
    }
}