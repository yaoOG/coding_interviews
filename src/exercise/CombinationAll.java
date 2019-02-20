package exercise;

/**
 * @author zhuyao
 * @date 2019/02/11
 */
public class CombinationAll {
    private static void multiCombination(String str) {
        if (null == str) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int iter = 1;
        while (iter <= str.length()) {
            multiCombination(str, iter, sb);
            ++iter;
        }
    }

    private static void multiCombination(String str, int m, StringBuilder sb) {
        if (m == 0) {
            System.out.println(sb.toString());
            return;
        }
        if (str.length() != 0) {
            sb.append(str.charAt(0));
            // 从剩余的n-1个中选择m-1个
            multiCombination(str.substring(1), m - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            // 从剩余的n-1个中选择m个
            multiCombination(str.substring(1), m, sb);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        multiCombination(str);
    }
}
