package adventofcode;

public class E108ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if (nums.length == 0 || start > end) return null;

        int mid = start + (end-start)/2;

        TreeNode runner = new TreeNode(nums[mid]);
        runner.left = dfs(nums, start, mid-1);
        runner.right = dfs(nums, mid+1, end);

        return runner;
    }
    public static void main(String[] strings) {
        int[] nums = {-10,-3,0,5,9};

        TreeNode res = new E108ConvertSortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(res.val == 0);
        System.out.println(res.left.val == -10);
        System.out.println(res.right.val == 5);
        System.out.println(res.left.right.val == -3);
        System.out.println(res.right.right.val == 9);
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
