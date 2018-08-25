package 排序.归并排序;

/**
 * 将数组分割，left ~ mid，mid+1 ~ right
 *
 */
public class Solution {

    private void sort(int[] a, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(a, left, mid, tmp);
            sort(a, mid + 1, right, tmp);
            merge(a, left, mid, right, tmp);
        }
    }

    public void merge(int[] a, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[index++] = a[i++];
            } else {
                tmp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = a[i++];
        }
        while (j <= right) {
            tmp[index++] = a[j++];
        }
        for (int t = left; t <= right; t++) {
            a[t] = tmp[t];
        }
    }

    public static void main(String s[]) {
        int a[] = {51, 46, 20, 20, 65, 97, 82, 30, 77, 50};
        int tmp[] = new int[a.length];
        new Solution().sort(a, 0, a.length - 1, tmp);
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }
}
