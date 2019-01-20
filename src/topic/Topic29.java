package topic;

import java.util.ArrayList;

/**
 * @author zhuyao
 * @date 2019/01/20
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，如：
 *
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 *
 * 1   2   3   4
 * 9   10  11  12
 * 13  14  15  16
 * 则依次打印1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 */
public class Topic29 {
    public ArrayList<Integer> printMatrixClockwisely(int[][] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int rows = nums.length;
        int cols = nums[0].length;
        if (nums == null || cols <= 0 || rows <= 0) {
            return null;
        }
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(list, nums, cols, rows, start);
            ++start;
        }
        return list;
    }

    private void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
                                     int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                list.add(number);
            }
        }
        //从右向左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = nums[endY][i];
                list.add(number);
            }
        }
        //从下向上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Topic29 topic29 = new Topic29();
        ArrayList<Integer> list = topic29.printMatrixClockwisely(nums);
        for (Integer integer : list) {
            System.out.print(integer+"\t");
        }
    }

}
