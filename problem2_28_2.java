package leetcode;

public class problem2_28_2
{
    public boolean isValidBST(TreeNode root) {
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }



}
