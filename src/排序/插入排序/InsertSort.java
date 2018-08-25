package 排序.插入排序;

public class InsertSort {
    public static void main(String s[]) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        new InsertSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmp < a[j]) {
                    a[j + 1] = a[j];
                } else break;
            }
            a[j + 1] = tmp;
        }
    }

    private void swap(int[] a, int j, int i) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}
