package 栈的min函数;

import java.util.Stack;

/**
 * 借助辅助栈存放最小值
 */
public class Solution {
    //原始压入顺序
    Stack<Integer> stack1 = new Stack<>();
    //栈顶始终放着动态的最小值
    Stack<Integer> stack2 = new Stack<>();

    public void push(int value) {
        if (!stack2.empty()) {
            if (stack2.peek() > value) {
                stack2.push(value);
            } else {
                stack2.push(stack2.peek());
            }
        } else {
            stack2.push(value);
        }
        stack1.push(value);
    }

    public int pop() {
        stack2.pop();
        return stack1.pop();
    }

    public int min() {
        return stack2.peek();
    }
}
