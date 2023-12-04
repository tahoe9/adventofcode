package adventofcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class E637AverageLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList();

        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);

        while(!q.isEmpty()) {
            double sum = 0;
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(sum/size);
        }

        return res;
    }

    public static void main(String[] strings) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> res = new E637AverageLevelsInBinaryTree().averageOfLevels(root);
        System.out.println(res.get(0) == 3.00000);
        System.out.println(res.get(1) == 14.50000);
        System.out.println(res.get(2) == 11.00000);
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
