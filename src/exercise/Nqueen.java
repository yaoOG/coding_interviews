package exercise;

/**
 * @author zhuyao
 * @date 2019/02/11
 */
public class Nqueen {
    /**
     * 下标i表示第几行，x[i]表示第i行皇后的位置,注意此处0行不用
     */
    private int[] x;
    /**
     * 皇后的数目
     */
    private int queenNum;
    /**
     * 解的数目
     */
    private int methodNum;

    private Nqueen(int queenNum) {
        this.queenNum = queenNum;
        //注意，这里我们从第1行开始算起，第0行不用
        this.x = new int[queenNum + 1];
        //从第一个皇后开始递归
        backtrack(1);
    }

    /**
     * 一行一行的确定该行的皇后位置
     *
     * @param t 第几个
     */
    private void backtrack(int t) {
        //如果当前行大于皇后数目，表示找到解了
        if (t > queenNum) {
            methodNum++;//sum为所有的可行的解
            //依次打印本次解皇后的位置
            for (int m = 1; m <= queenNum; m++) {
                //System.out.println(x[m]);//这一行用输出当递归到叶节点的时候，一个可行解
                //这里只是为了好看才写成下面的
                for (int k = 1; k <= queenNum; k++) {
                    if (k == x[m]) {
                        System.out.print(x[m] + " ");
                    } else {
                        //用*表示没有被用到的位置
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        } else {
            for (int i = 1; i <= queenNum; i++) {
                //第t行上皇后的位置只能是1-queenNum
                x[t] = i;
                //此处的place函数用来进行我们上面所说的条件的判断，如果成立，进入下一级递归,即放置下一个皇后
                if (place(t)) {
                    backtrack(t + 1);
                }
            }
        }
    }

    /**
     * 判断第k行皇后可以放置的位置
     *
     * @param k k表示第k行，X[K]k表示第k行上皇后的位置
     * @return boolean false表示此处不能放置皇后
     */
    private boolean place(int k) {
        for (int j = 1; j < k; j++) {
            // 如果当前传入的第K行上的皇后放置的位置和其它皇后一个对角线(abs(x[k]- x[j])==abs(k-j)或一个直线上(x[j] == x[k])
            if (Math.abs(x[k] - x[j]) == Math.abs(k - j) || (x[j] == x[k])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueen nQueen = new Nqueen(8);
        System.out.println("总共解数为：" + nQueen.methodNum);

    }
}
