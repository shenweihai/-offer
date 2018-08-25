package 测试;

import java.util.Arrays;

public class 插入 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] > a[j - 1]) {
                    break;
                } else {
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
