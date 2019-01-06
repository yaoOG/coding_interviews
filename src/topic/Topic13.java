package topic;

/**
 * @author: nathan
 * @date: 2019/1/6
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18(表示35行，37列，所有的数字拆开。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Topic13 {
    /**
     * @param threshold 阈值
     * @param rows      矩阵行数
     * @param cols      矩阵列数
     * @return 机器人能到达的格子数
     */
    private static int getMoveCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visitedMark = new boolean[rows * cols];
        return moveRecursion(threshold, rows, cols, 0, 0, visitedMark);
    }

    /*
     * 判断从第row行、第col列出发可以到达的格子数
     */
    private static int moveRecursion(int threshold, int rows, int cols, int row, int col, boolean[] visitedMark) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visitedMark)) {
            visitedMark[row * cols + col] = true;
            count = 1 + moveRecursion(threshold, rows, cols,
                    row - 1, col, visitedMark)
                    + moveRecursion(threshold, rows, cols,
                    row, col - 1, visitedMark)
                    + moveRecursion(threshold, rows, cols,
                    row + 1, col, visitedMark)
                    + moveRecursion(threshold, rows, cols,
                    row, col + 1, visitedMark);
        }
        return count;
    }

    //检查机器人能否到达该格子
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visitedMark) {
        return row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visitedMark[row * cols + col];
    }

    /**
     * @param number 需要求解的整数
     * @return 该整数各位之和
     */
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int threshold = 2;
        int rows = 3;
        int cols = 3;
        int count = getMoveCount(threshold, rows, cols);
        System.out.println(count);
    }
}
