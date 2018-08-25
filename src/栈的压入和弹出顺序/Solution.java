package 栈的压入和弹出顺序;

import java.util.Stack;

/**
 * 初始化一个pop指针
 * 按照压入顺序压入元素
 * 每压一个元素就判断栈顶元素是否等于当前出栈元素
 * 是则pop，index++
 * 当所有元素已入栈
 * 判断栈是否为空，为空则return true
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
