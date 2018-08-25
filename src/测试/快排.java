package 测试;

import java.util.Arrays;

public class 快排 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        quick(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quick(int[] a, int low, int high) {
        if (low < high) {
            int mid = quickOnce(a, low, high);
            quick(a, low, mid - 1);
            quick(a, mid + 1, high);
        }
    }

    private static int quickOnce(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (a[high] > key) high--;
            while (a[low] < key) low++;
            if (low < high) {
                swap(a, low, high);
            }
            /*while (low < high && a[high] > key) high--;
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (low < high && a[low] < key) low++;
            if (low < high) {
                a[high] = a[low];
                high--;
            }*/
        }
        a[low] = key;
        return low;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
