package topic;

import java.util.Stack;

/**
 * @author zhuyao
 * @date 2019/01/20
 */
public class Topic30 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
     * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
     */
    public static class StackWithMin {

        /**
         * 当前栈
         */
        Stack<Integer> stack = new Stack<>();
        /**
         * 辅助栈
         */
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            //如果最小值大于当前压入栈的数值，则将node赋予最小值并将该值存入最小值栈中
            if (minStack.size() == 0 || node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
            //将传入的值存入当前栈中
            stack.push(node);
        }

        public void pop() {
            //如果当前栈本身为空，则直接返回即可
            if (stack.size() == 0) {
                return;
            }
            //否则同步弹出即可
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
