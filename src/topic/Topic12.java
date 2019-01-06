package topic;

/**
 * @Author: nathan
 * @Date: 2019/1/6
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b t g c f c s j d e h 矩阵中包含一条字符串”bfce”的路径，但是矩阵中不包含”abfb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Topic12 {
    /**
     * @param matrix 题目给出的矩阵
     * @param rows   题目给出的矩阵的行
     * @param cols   题目给出的矩阵的列
     * @param str    需要判断的路径
     * @return 是否有这条路径
     */
    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || matrix.length < 1 || matrix.length < str.length) return false;
        boolean[] visited = new boolean[rows * cols];
        int curLength = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (coreHasPath(matrix, rows, cols, i, j, str, visited, curLength)) return true;
            }
        }
        return false;
    }

    /**
     * @param matrix    题目给出的矩阵
     * @param rows      题目给出的矩阵的行
     * @param cols      题目给出的矩阵的列
     * @param row       矩阵中当前各自的行
     * @param col       矩阵中当前各自的列
     * @param str       需要判断的路径
     * @param visited   布尔型矩阵，true代表当前各自已经访问过，false代表当前格子没有被访问过
     * @param curLength 需要判断的路径的当前位置
     * @return 是否有这条路径
     */
    private static boolean coreHasPath(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] visited, int curLength) {
        if (curLength == str.length) return true;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[curLength]) {
            curLength++;
            visited[row * cols + col] = true;
            hasPath = coreHasPath(matrix, rows, cols, row - 1, col, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row + 1, col, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row, col - 1, str, visited, curLength) ||
                    coreHasPath(matrix, rows, cols, row, col + 1, str, visited, curLength);
            if (!hasPath) {
                visited[row * cols + col] = false; //return hasPath回到上一层调用，curLength的值会自动回到上一层调用时的值
            }
        }
        return hasPath;
    }


    public static void main(String[] args) {
        char[] matrix = new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = new char[]{'A', 'B', 'C', 'C', 'E', 'D'};
        System.out.println("result " + hasPath(matrix, 3, 4, str));
    }

}
