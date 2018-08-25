package 左旋转字符串;

/**
 * 拼接字符串
 * doubleStr=str+str
 * 然后StringBuilder从n到n+length-1
 */
public class Solution1 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        n %= str.length();
        String doubleStr = str + str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(doubleStr.charAt(i + n));
        }
        return sb.toString();
    }
}