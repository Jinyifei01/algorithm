package leetcode;

public class problem3_7 {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        Caculate(root);
        return sum;

    }

    private Integer Caculate(TreeNode root) {
        if (root == null) return 0;
        Integer left = Math.max(Caculate(root.left), 0);
        Integer right = Math.max(Caculate(root.right), 0);
        sum = Math.max(left + right + root.val, sum);
        return Math.max(left, right) + root.val;
    }

}
