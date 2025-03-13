package leetcode;

public class problem3_7_2 {
//    class Solution {
//        int maxSum = Integer.MIN_VALUE;
//
//        public int maxPathSum(TreeNode root) {
//            maxGain(root);
//            return maxSum;
//        }
//
//        public int maxGain(TreeNode node) {
//            if (node == null) {
//                return 0;
//            }
//
//            // 递归计算左右子节点的最大贡献值
//            // 只有在最大贡献值大于 0 时，才会选取对应子节点
//            int leftGain = Math.max(maxGain(node.left), 0);
//            int rightGain = Math.max(maxGain(node.right), 0);
//
//            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
//            int priceNewpath = node.val + leftGain + rightGain;
//
//            // 更新答案
//            maxSum = Math.max(maxSum, priceNewpath);
//
//            // 返回节点的最大贡献值
//            return node.val + Math.max(leftGain, rightGain);
//        }
//    }
//
//    核心是注意当前节点的最大路径，与当前节点作为子节点时的贡献是两个不同的值
//    当前节点的最大路径： max(自己，自己+左边，自己+右边，自己 + 左边 + 右边）
//            当前节点作为子节点时的贡献：max(自己，自己+左边，自己+右边）
//            后者相对前者，少了左右都存在的情况。因为作为子节点时，一条路如果同时包含左右，根就被包含了2次，不符合题目只出现一次的限制了。

}
