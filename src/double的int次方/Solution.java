package double的int次方;

public class Solution {
    /*public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            double result = result(base, exponent);
            return result;
        } else {
            double result = result(base, -exponent);
            return 1.0 / result;
        }
    }

    public double result(double base, int exponent) {
        int s = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {//奇数
                s *= base;
            }
            base *= base;
            exponent = exponent >> 1;
        }
        return s;
    }*/


    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int abs = Math.abs(exponent);
        double r = 1.0;
        while (abs != 0) {
            if ((abs & 1) == 1) {
                r *= base;
            }
            base *= base;
            abs = abs >> 1;
        }
        return exponent > 0 ? r : (1.0 / r);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Power(2, 3));
        System.out.println(1>>1);
        System.out.println(1>>>1);
    }
}