package 约瑟夫环;

/**
 * LinkedList模拟
 * 初始化index=0,
 * 下一个删除的index=（index+m-1）%list.size()
 * 当链表不为空时，一直remove
 * 直到最后一个
 */

/**
 * m=4时
 * 0 1 2 3 4 5 6 7 8
 * 5 6 7 8 0 1 2 3 4
 * 上一层编号=（新环编号+m）%上一层总数
 * 第sum-2环的第一次出环->第sum-1环的第二次出环->第sum环的第三次出环
 * 即第1环的第一次出环->第sum环的第sum次出环
 * 第1环的第一次出环=0
 * 第二环=(0+4)%2=0
 * 第三环=(0+4)%3=1
 * 第四环=(1+4)%4=1
 * ...
 * 第sum环=(f(sum-1)+m)%sum
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
    /*public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.offer(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.pop();
    }*/

    public static void main(String s[]) {
        System.out.println(-4 % 9 == 5);
        //System.out.println(new Solution().LastRemaining_Solution(5, 3));
    }
}