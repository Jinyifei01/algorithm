package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class problem3_3 {
   //最简单中序遍历
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                --k;
                if (k == 0) {
                    break;
                }
                root = root.right;
            }
            return root.val;
        }
//使用递归解决
    public int kthSmallest2(TreeNode root, int k) {
        int leftNodes = countNodes(root.left);
        if(leftNodes < k - 1){  //答案存在右子树中
            return kthSmallest(root.right,k - leftNodes - 1);
        }else if(leftNodes == k - 1){
            return root.val;
        }else{
            return kthSmallest(root.left,k);
        }
    }
    //左神递归套路分析左右子树返回信息只需要节点数，因此无需额外定义数据结构
    public int countNodes(TreeNode root){
        //base case返回0
        if(root == null) return 0;
        //递归处理左右子树并接收返回值
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        //判断分析本层递归返回值的具体值
        return leftNodes + rightNodes + 1;
    }



}
