package 测试;

import java.util.Arrays;

public class FullOrder {
    public static void main(String[] args) {
        String str = "abcd";
        char[] a = str.toCharArray();
        range(a, 0);
    }

    private static void range(char[] a, int begin) {
        if (begin == a.length - 1) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = begin; i < a.length; i++) {
                //1.把第一个字符与后边的所有字符交换
                swap(a, begin, i);
                //2.固定第一个字符,对后边的所有字符全排列
                range(a, begin + 1);
                //3.把交换到后边的字符交换回来
                swap(a, begin, i);
            }

        }
    }

    private static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
