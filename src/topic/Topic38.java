package topic;

import java.util.Scanner;

/**
 * @author zhuyao
 * @date 2019/02/10
 */
public class Topic38 {
    /**
     * 题目：输入一个字符串，打印出该字符事中字符的所有排列。
     * 例如输入字符串abc，则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     */

    public static void main(String[] args) {
        String str = "";

        Scanner scan = new Scanner(System.in);

        str = scan.nextLine();

        permutation(str.toCharArray(), 0);
    }

    /**
     * 求字符数组的排列
     *
     * @param str   待排列的字符串
     * @param begin 当前处理的位置
     */
    public static void permutation(char[] str, int begin) {
        if (begin >= str.length)
            return;
        // 如果是最后一个元素了，就输出排列结果
        if (begin == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int j = begin; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[begin];
                str[begin] = temp;
                // 处理下一个位置
                permutation(str, begin + 1);

                temp = str[j];
                str[j] = str[begin];
                str[begin] = temp;
            }
        }
    }
}
