package 二替换空格;

/**
 * 先找出空格数量，新建一个数组=原长度+空格数量
 * 遍历原数组
 * 1.碰见空格，新数组index++ 替换为 %20
 * 2.不是空格，新数组index++ = array[i]
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str.toString();
        }
        int blankCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankCount++;
            }
        }
        int newLength = str.length() + 2 * blankCount;
        char newArray[] = new char[newLength];
        int index = newLength - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                newArray[index--] = '0';
                newArray[index--] = '2';
                newArray[index--] = '%';
            } else {
                newArray[index--] = str.charAt(i);
            }
        }
        return new String(newArray);
    }
}