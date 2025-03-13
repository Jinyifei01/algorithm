package leetcode;

public class problem2_25 {


    //递归查询 暴力解法
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
