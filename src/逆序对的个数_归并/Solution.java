package 逆序对的个数_归并;

/**
 * 将数组递归分割，left ~ mid，mid+1 ~ right
 * 然后merge
 * 1.将左边和右边数组按顺序插入到，tmp[index++]=a[i++]或a[j++]
 * 2.如果出现左侧大于右侧，逆序对count+=index-i+1
 * 如果左侧数组没完，tmp[index++]=a[i++]
 * 如果右侧数组没完，tmp[index++]=a[j++]
 * tmp数组的left~right赋给a
 */
public class Solution {
    int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return count;
        }
        sort(array, 0, array.length - 1, new int[array.length]);
        return count;
    }

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
                count = count + mid - i + 1;//a[i]之后的数都大于a[j]
                count = count > 1000000007 ? count % 1000000007 : count;
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
        System.out.println(new Solution().InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }
}