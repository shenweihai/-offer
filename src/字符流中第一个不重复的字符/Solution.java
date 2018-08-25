package 字符流中第一个不重复的字符;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实例化一个队列，存放插入的元素
 * 实例化一个数组，记录元素出现个数
 * 当插入时，如果当前字符没出现，则offer
 * 当输出时，先把出现过的poll，然后peek
 */
public class Solution {
    Queue<Character> head = new LinkedList<>();
    int[] count = new int[1 << 16];

    public void Insert(char ch) {
        count[ch]++;
        if (count[ch] == 1) {
            head.offer(ch);
        }
    }

    public char FirstAppearingOnce() {
        while (!head.isEmpty() && count[head.peek()] != 1) {
            head.poll();
        }
        return head.peek() == null ? '#' : head.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert('g');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('o');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('o');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('g');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('l');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('e');
        System.out.println(solution.FirstAppearingOnce());
    }
}