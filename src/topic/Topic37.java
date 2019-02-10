package topic;

/**
 * @author zhuyao
 * @date 2019/02/10
 */
public class Topic37 {
    private String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private int index = -1;

    public TreeNode deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        return deserialize(strs);
    }

    private TreeNode deserialize(String[] strs) {
        index++;
        if (!"#".equals(strs[index])) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = deserialize(strs);
            root.right = deserialize(strs);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Topic37 s3 = new Topic37();
        /*
          构造二叉树
                1
               / \
              2   3
             / \ / \
            4  5 6  7
         */
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        TreeNode right2 = new TreeNode(6);
        TreeNode left2 = new TreeNode(7);

        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;

        root.left = left;
        root.right = right;
        //输出：1,2,4,#,#,5,#,#,3,7,#,#,6,#,#,
        System.out.println(s3.serialize(root));
        //输出：2
        System.out.println(s3.deserialize("1,2,4,#,#,5,#,#,3,7,#,#,6,#,#,").left.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
