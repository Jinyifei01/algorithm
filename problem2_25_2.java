package leetcode;

public class problem2_25_2 {

    //使用递归
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left);  // 先反转左子树，保存结果（原左子树反转后的结构）
        TreeNode right = invertTree(root.right);// 再反转右子树，保存结果（原右子树反转后的结构）
        root.left = right;  // 将反转后的右子树赋值给左节点
        root.right = left;  // 将反转后的左子树赋值给右节点
        return root;
    }
}
