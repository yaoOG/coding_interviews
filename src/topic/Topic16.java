package topic;

/**
 * @author zhuyao
 * @date 2019/01/07
 */
public class Topic16 {

    /**
     * 用右移运算代替除2，用位与运算符代替了求余运算符（%)来判断一个数是奇数还是偶数
     * @param base
     * @param exponent
     * @return 结果
     */
    private static double powerWithExponent2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithExponent2(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        powerWithExponent2(3, 2);
    }
}
