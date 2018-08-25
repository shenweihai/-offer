package 测试;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = quckOnce(a, start, end);
            quickSort(a, start, mid - 1);
            quickSort(a, mid + 1, end);
        }
    }

    public static int quckOnce(int a[], int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] > key) {
                high--;
            }
            while (low < high && a[low] < key) {
                low++;
            }
            if (low < high) {
                swap(a, low, high);
            } else {
                return low;
            }
        }
        a[low] = key;
        return low;
    }

    private static void swap(int[] a, int low, int high) {
        int tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
    }
}
