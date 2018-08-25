package 排序.冒泡排序;

public class BubbleSort {
    public static void main(String s[]) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        new BubbleSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] a, int j, int i) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
