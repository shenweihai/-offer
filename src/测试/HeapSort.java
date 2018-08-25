package 测试;

public class HeapSort {
    /**
     * 最小堆
     *
     * @param a
     * @param start
     * @param length
     */
    public static void adjust(int a[], int start, int length) {
        int index = start;
        for (int i = 2 * start + 1; i < length; i = 2 * i + 1) {
            if (i < length - 1 && a[i] > a[i + 1]) {
                i++;
            }
            if (a[index] > a[i]) {
                swap(i, index, a);
                index = i;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        //建堆
        for (int i = (a.length >> 1) - 1; i >= 0; i--) {
            adjust(a, i, a.length);
        }
        //先swap 0和末尾元素，然后从上至下调整
        for (int i = a.length - 1; i > 0; i--) {
            swap(i, 0, a);
            adjust(a, 0, i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
