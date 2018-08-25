package 排序.桶排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String s[]) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50, 1, 3, 5, 4, 2, 21, 19, 20, 28, 234, 456, 234, 12, 3, 45, 56, 34, 67, 45, 34, 56, 4, 5, 67, 345, 678, 456, 46, 67, 8, 4, 56, 5, 5, 75, 4, 4, 6, 867, 86, 75, 75, 4, 645, 64, 75, 675, 67, 57, 5, 675, 7, 57, 56, 75, 67, 57, 65, 867, 67,1000000000};
        new BucketSort().sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] a) {
        int min = min(a);
        int max = max(a);
        int bucketSize = 3;
        int bucketCount = (max - min) / bucketSize + 1;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            list.add(new ArrayList<>());
        }
        for (int i : a) {
            list.get((i - min) / bucketSize).add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list.get(i).size(); i1++) {
                a[index++] = list.get(i).get(i1);
            }
        }
    }

    int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }
}
