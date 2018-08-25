package 测试;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        /*for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }*/
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j >= i + 1; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
