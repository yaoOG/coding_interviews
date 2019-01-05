package exercise;

/**
 * @Author: nathan
 * @Date: 2019/1/5
 */
public class CompareRecursiveAndIterative {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(getIntegerByIterative(n));
        System.out.println(getIntegerByRecursive(n));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    private static int getIntegerByRecursive(int n) {
        return n < 0 ? 0 : n + getIntegerByRecursive(n - 1);
    }

    /**
     * 循环
     * @param n
     * @return
     */
    private static int getIntegerByIterative(int n) {
        int result = 0;
        for (int i = 0; i <=n ; i++) {
            result += i;
        }
        return result;
    }

}
