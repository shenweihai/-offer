package 反转单词;

/**
 * 先反转整个数组
 * 记下left边界，遇见空格就反转单词
 * 因为最后一个单词没有空格，需要单独反转
 */

/**
 * 先分割字符串
 * 在反转单词
 */
public class Solution {
    /*public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        String[] array = str.split(" ");
        *//*for (int i = 0; i < array.length; i++) {
            char[] subArray = array[i].toCharArray();
            rotate(subArray, 0, array[i].length() - 1);
            array[i] = new String(subArray);
        }*//*
        rotate(array, 0, array.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i]);
            } else sb.append(array[i] + " ");
        }
        return sb.toString();
    }*/
    /*private void rotate(String[] array, int start, int end) {
        while (start < end) {
            String tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }*/
    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        rotate(array, 0, array.length - 1);
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                rotate(array, left, i - 1);
                left = i + 1;
            }
        }
        rotate(array, left, array.length - 1);
        return new String(array);
    }

    private void rotate(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }
}