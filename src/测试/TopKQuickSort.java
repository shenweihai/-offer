package 测试;

import 字典生成算法.Solution;

import java.util.ArrayList;

public class TopKQuickSort {
    public static void main(String[] args) {
        int a[] = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        new TopKQuickSort().GetLeastNumbers_Solution(a,10);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    static ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k <= 0 || input.length <= 0 || k > input.length - 1) {
            return result;
        }
        sort(input, 0, input.length - 1, k);
        return result;
    }

    private void sort(int[] a, int start, int end, int k) {
        int mid = quickOnce(a, start, end);
        while (start < end && mid != k - 1) {
            if (mid > k - 1) {
                mid = quickOnce(a, start, mid - 1);
            } else {
                mid = quickOnce(a, mid + 1, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(a[i]);
        }
    }

    private static int quickOnce(int[] a, int low, int high) {
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
