package 数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 实例化两个优先级队列
 * 一个递增队列（存放比较大的元素，但队首是对内最小元素），一个递减队列（存放比较小的元素，但队首是对内最大元素）
 * 当前元素个数为奇数时，待插入元素先进递增队列把最小元素poll出来，然后插入到递减队列
 * 为奇数时，待插入元素先进递减队列把最大元素poll出来，然后插入到递增队列
 * 取中位数时，总数为奇数，则直接peek递减队列，总数为偶数时，两个队列都poll之和/2
 */
public class Solution {

    int count = 0;
    //递增队列
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
    //递减队列
    PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1) {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 1) {
            return Double.valueOf(minQueue.peek());
        } else {
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        }
    }

    public static void main(String s[]) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        Solution solution = new Solution();
        solution.Insert(5);
        System.out.println(solution.GetMedian());
        solution.Insert(2);
        System.out.println(solution.GetMedian());
        solution.Insert(3);
        System.out.println(solution.GetMedian());
        solution.Insert(4);
        System.out.println(solution.GetMedian());
        solution.Insert(1);
        System.out.println(solution.GetMedian());
        solution.Insert(6);
    }
}