package 测试;

import java.util.Arrays;

public class 堆排 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        for (int i = ((a.length) >> 1) - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            adjust(a, 0, i);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void adjust(int[] a, int start, int length) {
        int value = a[start];
        int index = start;
        for (int i = 2 * start + 1; i < length; i = 2 * i + 1) {
            //有右孩子，并且左孩子小于右孩子
            if (i + 1 < length && a[i] < a[i + 1]) {
                i++;
            }
            if (value < a[i]) {
                a[index] = a[i];
                index = i;
            }
        }
        a[index] = value;
    }
}
