package 表示数值的字符串;

/**
 * 1.e或E不能出现两次，e后面要跟数字
 * 2.第一次出现'+''-'号，且不在字符串开头，则必须跟在e后面
 * 3.第二次出现'+''-'号，则必须跟在e后面
 * 4.e后面不能出现小数点
 * 5.非法字符
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        boolean hasE = false, hasPoint = false, hasSign = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                if (i + 1 > str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (hasSign && str[i - 1] != 'E' && str[i - 1] != 'e') return false;
                if (!hasSign && i > 0 && str[i - 1] != 'E' && str[i - 1] != 'e') return false;
                hasSign = true;
            } else if (str[i] == '.') {
                if (hasPoint || hasE) return false;
                hasPoint = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumeric(new char[]{'e'}));
    }
}