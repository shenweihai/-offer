package 测试;

import java.util.Arrays;

public class 选择 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    k = j;
                }
            }
            swap(a, k, i);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
