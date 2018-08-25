package 丑数;

/**
 * 丑数a[i]=2,3,5 * 队列还未用过的丑数即a[t]
 * t2，t3，t5三个指针，指向当前2,3,5队列
 * 丑数a[i]=min(2*a[t2],3*a[t3],5*a[t5])
 * a[t2],a[t3],a[t5]分别代表2,3,5队列还没用过的最小丑数
 * a[i]等于谁，谁的指针向后移动
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int t2 = 0, t3 = 0, t5 = 0;
        int[] ugly = new int[index];
        ugly[0] = 1;//第一个丑数为1
        for (int i = 1; i < index; i++) {
            int min = min(2 * ugly[t2], 3 * ugly[t3], 5 * ugly[t5]);
            if (min == 2 * ugly[t2]) {
                t2++;
                ugly[i] = min;
            }
            if (min == 3 * ugly[t3]) {
                t3++;
                ugly[i] = min;
            }
            if (min == 5 * ugly[t5]) {
                t5++;
                ugly[i] = min;
            }
        }
        return ugly[index - 1];
    }

    static int min(int a, int b, int c) {
        return a > b ? (b > c ? c : b) : (a > c ? c : a);
    }
}