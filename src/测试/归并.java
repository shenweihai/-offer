package 测试;

import java.util.Arrays;

public class 归并 {
    public static void main(String[] args) {
        int a[] = {51, 46, 20, 20, 65, 97, 82, 30, 77, 50};
        int tmp[] = new int[a.length];
        sort(a, 0, a.length - 1, tmp);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) >> 1;
            sort(a, low, mid, tmp);
            sort(a, mid + 1, high, tmp);
            merge(a, low, mid, high, tmp);
        }
    }

    private static void merge(int[] a, int low, int mid, int high, int[] tmp) {
        int i = low;
        int j = mid + 1;
        int index = low;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[index++] = a[i++];
            } else {
                tmp[index++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[index++] = a[i++];
        }
        while (j <= high) {
            tmp[index++] = a[j++];
        }
        for (int k = low; k <= high; k++) {
            a[k] = tmp[k];
        }
    }
}
