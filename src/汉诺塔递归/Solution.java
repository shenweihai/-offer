package 汉诺塔递归;

import java.util.LinkedList;

public class Solution {
    private static int steps;

    /**
     * A通过B将n个圆盘移到C上
     * 1.n-1个A->B
     * 2.第n个A->C
     * 3.n-1个B->C
     *
     * @param n
     * @param A
     * @param B
     * @param C
     * @return
     */
    public void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            move(1, A, C);
        } else {
            hanoi(n - 1, A, C, B);
            move(n, A, C);
            hanoi(n - 1, B, A, C);
        }
    }

    public void move(int n, char src, char dest) {
        System.out.println("第" + (++steps) + "步：移动第" + n + "个圆盘" + src + "->" + dest);
    }

    public static void main(String s[]) {
        new Solution().hanoi(7, 'A', 'B', 'C');
        System.out.println(steps);
    }
}
