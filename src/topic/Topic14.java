package topic;

/**
 * @author: nathan
 * @date: 2019/1/6
 */
public class Topic14 {
    /*
     * 使用动态规划的思想
     */
    private static int solution1(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (products[j] * products[i - j] > max)
                    max = products[j] * products[i - j];
            }
            products[i] = max;
        }
        return products[length];
    }

    /*
     * 使用贪婪法
     */
    private static int solution2(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        //尽可能多的剪长度为3的绳子
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        //此时，更好的方法就是把绳子剪成长度为2的两段，因为2x2>1x3
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(solution2(5));
    }
}
