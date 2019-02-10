package topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuyao
 * @date 2019/01/20
 */
public class Topic32 {

    /**
     * 二叉树的树结点
     */
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
     * 例如下的二叉树，
     * 8
     * /    \
     * 6     10
     * /  \   / \
     * 5   7  9  11
     * 则依次打印出8、6、10、5、3 、9、11.
     *
     * @param root 树的结点
     */
    public static ArrayList<Integer> printFromTopToButtom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        // 层次遍历树和图都需要一个队列，这儿用一个ArrayList实现 queue的数据逻辑
        // 用LinkedList更好，它实现了Queue接口 可以调用 队列的 add offer element peek poll等方法
        // 并且基本都是添加删除操作，效率会好一些
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            list.add(tmp.value);
        }
        return list;
    }

    public static LinkedList<Integer> printFromTopToButtomByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        // 先添加根结点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public void printTreeSplitRow(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        // 分别记录当前行未打印个数 以及下一行需要打印的个数
        int nextLevel = 0, toBePrint = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.get(0);
            System.out.print(tmp.value + " ");
            if (tmp.left != null) {
                queue.add(tmp.left);
                nextLevel++;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nextLevel++;
            }
            queue.remove(0);
            toBePrint--;
            if (toBePrint == 0) {
                // 当前行打印完毕
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    // 之字形打印二叉树 各行 从左往右 从右往左 交替打印
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // 按照这个要求我们需要两个栈辅助
        // 交替使用两个栈 奇数层数据存放在stack1 偶数层在stack2
        // 奇数层我们把下一层数据先left后right压入stack2 偶数层把下一层先right后left压入stack1
        // 这样就可以实现隔层之字形打印
        ArrayList<TreeNode> stack1 = new ArrayList<>();
        ArrayList<TreeNode> stack2 = new ArrayList<>();
        // 用一个flag标记 当前是奇数层还是偶数层
        boolean flag = true;
        TreeNode tmp = null;
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                tmp = stack1.get(stack1.size() - 1);
                stack1.remove(stack1.size() - 1);
            } else {
                tmp = stack2.get(stack2.size() - 1);
                stack2.remove(stack2.size() - 1);
            }
            System.out.print(tmp.value + " ");
            if (flag) {
                if (tmp.left != null) {
                    stack2.add(tmp.left);
                }
                if (tmp.right != null) {
                    stack2.add(tmp.right);
                }
            } else {
                if (tmp.right != null) {
                    stack1.add(tmp.right);
                }
                if (tmp.left != null) {
                    stack1.add(tmp.left);
                }
            }
            // 当前层打印完毕 换行 并更改flag的值
            if (flag) {
                if (stack1.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            } else {
                if (stack2.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            }
        }
    }

    public static void main(String[] args) {

        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode();
        root.value = 8;
        root.left = new TreeNode();
        root.left.value = 6;
        root.left.left = new TreeNode();
        root.left.left.value = 5;
        root.left.right = new TreeNode();
        root.left.right.value = 7;
        root.right = new TreeNode();
        root.right.value = 10;
        root.right.left = new TreeNode();
        root.right.left.value = 9;
        root.right.right = new TreeNode();
        root.right.right.value = 11;
        printFromTopToButtom(root);

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode();
        root2.value = 1;
        root2.left = new TreeNode();
        root2.left.value = 3;
        root2.left.left = new TreeNode();
        root2.left.left.value = 5;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        printFromTopToButtom(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode();
        root3.value = 0;
        root3.right = new TreeNode();
        root3.right.value = 2;
        root3.right.right = new TreeNode();
        root3.right.right.value = 4;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        printFromTopToButtom(root3);

        // 1
        TreeNode root4 = new TreeNode();
        root4.value = 1;
        System.out.println("\n");
        printFromTopToButtom(root4);

        // null
        System.out.println("\n");
        printFromTopToButtom(null);

    }

}
