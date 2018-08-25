package 不用加减乘除做加法;

/**
 * 不带进位和sum=num1^num2
 * 进位carry=(num1&num2)<<1
 * num1=sum，num2=carry
 * 直到进位carry=0
 */
public class Solution {
    public int Add(int num1, int num2) {
        /**
         * num1^num2 两数和（不带进位）
         * num1&num2 <<1 进位
         * 两数相加
         */
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}