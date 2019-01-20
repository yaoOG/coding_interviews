package topic;

import java.util.Stack;

/**
 * @author zhuyao
 * @date 2019/01/20
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 */
public class Topic31 {

    private boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushA) {
            stack.push(i);
            while ((!stack.empty()) && (stack.peek() == popA[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Topic31 topic31 = new Topic31();
        int[] test = {1, 2, 3, 4, 5};
        int[] test1 = {4, 5, 3, 2, 1};
        boolean popOrder = topic31.isPopOrder(test, test1);
        System.out.println(popOrder);
    }


}
