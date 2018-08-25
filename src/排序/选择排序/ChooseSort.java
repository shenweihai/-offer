package 排序.选择排序;

public class ChooseSort {
    public static void main(String s[]) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        new ChooseSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            int min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    k = j;
                }
            }
            swap(a, i, k);
        }
    }

    private void swap(int[] a, int j, int i) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
