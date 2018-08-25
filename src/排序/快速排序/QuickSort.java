package 排序.快速排序;

public class QuickSort {
    public static void main(String s[]) {
        int a[] = {51, 46, 20, 20, 65, 97, 82, 30, 77, 50};
        new QuickSort().sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] a, int left, int right) {
        if (left < right) {
            int partition = sortOnce(a, left, right);
            sort(a, left, partition - 1);
            sort(a, partition + 1, right);
        }
    }

    private int sortOnce(int a[], int left, int right) {
        int key = a[left];
        int low = left, high = right;
        while (low < high) {
            while (low < high && a[high] >= key) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (low < high && a[low] <= key) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }
        a[low] = key;
        return low;
    }
}
