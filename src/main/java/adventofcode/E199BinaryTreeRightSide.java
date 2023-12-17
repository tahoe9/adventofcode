package adventofcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class E199BinaryTreeRightSide {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (i==0) res.add(node.val);
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }

        return res;
    }

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> res = new E199BinaryTreeRightSide().rightSideView(root);
        System.out.println(res.get(0) == 1);
        System.out.println(res.get(1) == 3);
        System.out.println(res.get(2) == 4);
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
