package leetcode;

public class problem3_6_2 {

    //递归算路径总和
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    //前缀和算法
//    class Solution {
//        public int pathSum(TreeNode root, int targetSum) {
//            Map<Long, Integer> prefix = new HashMap<Long, Integer>();
//            prefix.put(0L, 1);
//            return dfs(root, prefix, 0, targetSum);
//        }
//
//        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
//            if (root == null) {
//                return 0;
//            }
//
//            int ret = 0;
//            curr += root.val;
//
//            ret = prefix.getOrDefault(curr - targetSum, 0);
//            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
//            ret += dfs(root.left, prefix, curr, targetSum);
//            ret += dfs(root.right, prefix, curr, targetSum);
//            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);在递归遍历完当前节点的左右子树之后，我们需要撤销当前节点对前缀和计数的影响，以便回到上层节点时，不会受到当前节点影响的干扰。
//
//            return ret;
//        }
//    }




}
