package 滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 实例化一个队列，队首存放当前窗口最大值的下标
 * 1.当队列非空并且当前元素大于队尾元素时，将队列中小于当前元素的元素丢弃
 * 2.当前元素入队
 * 3.判断队首元素是否过期（在窗口之外），过期则丢弃
 * 4.判断当前窗口是否达到预期窗口大小，达到则将队首元素添加到结果
 * 直到元素被遍历完
 */
public class Solution {
    LinkedList<Integer> list = new LinkedList();

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return result;
        }
        if (num.length < size) {
            return findMax(num);
        }
        for (int i = 0; i < num.length; i++) {
            while (!list.isEmpty() && num[i] >= num[list.peekLast()]) {
                list.pollLast();
            }
            list.offer(i);
            if (i - size + 1 > list.peek()) {
                list.poll();
            }
            if (i + 1 >= size) {
                result.add(num[list.peek()]);
            }
        }
        return result;
    }

    private ArrayList<Integer> findMax(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = num[0];
        for (int i : num) {
            if (i > max) {
                max = i;
            }
        }
        list.add(max);
        return list;
    }

    public static void main(String[] args) {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        Solution solution = new Solution();
        ArrayList<Integer> list = solution.maxInWindows(num, 9);
        System.out.println(Arrays.toString(list.toArray()));
    }
}