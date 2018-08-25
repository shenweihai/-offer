package 排序.堆排序;

/**
 * 重建堆，从(length>>1)-1开始，adjust（a[],start,length)
 * 先swap 0和末尾元素，交换一次length--，然后从上至下调整
 */
public class HeapSort {
    public void adjust(int[] array, int start, int length) {
        int rootValue = array[start];//记下根节点
        int rootIndex = start;
        for (int i = 2 * start + 1; i < length; i = 2 * i + 1) {
            //考虑没有右节点情况
            if (i + 1 < length && array[i] < array[i + 1]) {
                i++;
            }
            if (rootValue < array[i]) {
                array[rootIndex] = array[i];//最大值变成根节点
                rootIndex = i;//记下被换过的位置
            } else {
                break;
            }
        }
        array[rootIndex] = rootValue;
    }

    public void sort(int[] array) {
        /**
         * 构建大顶堆
         */
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length);
        }
        /**
         * 从上到下调整，因为替换根节点后会导致下面的堆不满足性质
         * 让下层大节点浮上来，上层小节点沉下去
         */
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjust(array, 0, i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String s[]) {
        int a[] = {1, 6, 2, 0, 3, 546, 8, 435, 324, 34, 45, 434};
        new HeapSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
