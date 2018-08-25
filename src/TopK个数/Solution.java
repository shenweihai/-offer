package TopK个数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList rs = new ArrayList();
        if (input == null || input.length == 0 || k > input.length) {
            return rs;
        }
        sort(input, k);
        for (int i = input.length - 1; i > input.length - 1 - k; i--) {
            rs.add(input[i]);
        }
        return rs;
    }

    public void adjust(int[] array, int start, int length) {
        int rootValue = array[start];
        int rootIndex = start;
        for (int i = 2 * start + 1; i < length - 1; i = 2 * i + 1) {
            if (array[i] > array[i + 1]) {
                i++;
            }
            if (rootValue > array[i]) {
                array[rootIndex] = array[i];
                rootIndex = i;
            } else {
                break;
            }
        }
        array[rootIndex] = rootValue;
    }

    public void sort(int[] array, int k) {
        /**
         * 构建小顶堆
         */
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length);
        }
        /**
         * 从上到下调整
         */
        for (int i = array.length - 1; i > array.length - 1 - k; i--) {
            swap(array, 0, i);
            adjust(array, 0, i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}