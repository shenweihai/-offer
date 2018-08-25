package 字符串转换为整数;

/**
 * 判断第一位是否为'+'或者'-'
 * '+' flag=0,'-' flag=-1,其他flag='1'
 * 然后从后往前依次乘以1、10、100（可用移位）
 * 溢出也要进行判断，当sum超过范围，符号位为-则返回MIN_VALUE,否则返回MAX_VALUE
 */
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        long sum = 0;
        long ten = 1;
        long flag = 1;
        if (str.charAt(0) == '+') {
            flag = 0;
        }
        if (str.charAt(0) == '-') {
            flag = -1;
        }
        for (int i = str.toCharArray().length - 1; i >= (flag == 1 ? 0 : 1); i--) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return 0;
            }
            long tmp = (str.charAt(i) - 48) * ten;
            sum += tmp;
            if (sum > Integer.MAX_VALUE) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ten *= 10;
        }
        return (int) (sum * (flag == -1 ? -1 : 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().StrToInt("1231"));
    }
}