package 五两个栈实现队列;

import java.util.Stack;

/**
 * push直接push到stack1
 * pop则判断stack2是否为空
 * 1.为空，把stack1全部pop到stack2
 * 2.不为空，直接pop
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}