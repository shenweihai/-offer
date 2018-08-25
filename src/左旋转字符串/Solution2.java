package 左旋转字符串;

/**
 * 三次旋转字符串
 * s=abcXYZdef,x=abc,y=XYZdef
 * s1=yx,xT=cba,yT=fedZYX,(xTyT)T=XYZdefabc
 */
public class Solution2 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        n %= str.length();
        rotate(array, 0, n - 1);
        rotate(array, n, array.length - 1);
        rotate(array, 0, array.length - 1);
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
