package 构建乘积数组;

/***
 * 实例化B[]
 * 1  A1 ... An-1
 * A0 1
 * A0 A1 ... 1
 * 将斜对角线置为1
 * 先从上至下从左至右计算下三角
 * B0=1,B1=A0,B2=A0*A1 ...
 * 再从下至上从右至左计算上三角
 * Bn-1=Bn-1 *1,Bn-2=Bn-2 *An-1...
 * 用tmp表示当前需要乘的因子
 */
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A == null || A.length == 0) {
            return B;
        }
        B[0] = 1;
        int tmp = 1;
        for (int i = 1; i < A.length; i++) {
            tmp *= A[i - 1];
            B[i] = tmp;
        }
        tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }
}