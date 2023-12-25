package adventofcode;

import java.util.List;

public class E124MaximumPathSumOfBinaryTree {
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        max = Math.max(max, root.val+left+right);

        return root.val+Math.max(left, right);

    }

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new E124MaximumPathSumOfBinaryTree().maxPathSum(root) == 6);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
