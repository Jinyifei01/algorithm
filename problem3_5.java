package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem3_5 {

    //暴力方法 先前序遍历 再重新构建树
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    //总结：
    //递归扁平化左子树：首先处理当前节点的左子树。
    //调整左子树到右边：将当前节点的左子树移到右子树的位置，设置左子树为 null。
    //找到右子树的末尾：遍历新右子树的末端，确保可以把原来的右子树连接到链表的最后。
    //递归处理原右子树：在扁平化完左子树之后，继续递归扁平化原右子树。
//    public void flatten(TreeNode root) {
//        while (root != null) {
//            //左子树为 null，直接考虑下一个节点
//            if (root.left == null) {
//                root = root.right;
//            } else {
//                // 找左子树最右边的节点
//                TreeNode pre = root.left;
//                while (pre.right != null) {
//                    pre = pre.right;
//                }
//                //将原来的右子树接到左子树的最右边节点
//                pre.right = root.right;
//                // 将左子树插入到右子树的地方
//                root.right = root.left;
//                root.left = null;
//                // 考虑下一个节点
//                root = root.right;
//            }
//        }
//    }
// 非递归算法

   //递归算法
        public void flatten2(TreeNode root) {
            if (root == null) return;
            flatten2(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            flatten2(right);
            root.right = right;
        }




     //有点类似尾插法的思想，进行递归

//    class Solution {
//        public:
//        TreeNode* preNode;
//        void flatten(TreeNode* root) {
//            if (root == NULL) return;
//            flatten(root->right);
//            flatten(root->left);
//            root->left = NULL;
//            root->right = preNode;
//            preNode = root;
//        }
//    };



//    class Solution {
//        public void flatten(TreeNode root) {
//            while (root != null) {
//                TreeNode move = root.left;  // 保存当前节点的左子树
//
//                // 找到左子树的最右节点
//                while (move != null && move.right != null) {
//                    move = move.right;
//                }
//
//                // 如果左子树存在（move != null），则进行扁平化
//                if (move != null) {
//                    move.right = root.right;  // 将当前节点的右子树连接到左子树的最右节点
//                    root.right = root.left;   // 将左子树连接到当前节点的右边
//                    root.left = null;         // 将当前节点的左子树置为null
//                }
//
//                // 移动到当前节点的右子节点，继续处理下一个节点
//                root = root.right;
//            }
//        }
//    }
//
//    总结：
//    该算法通过迭代的方式将二叉树扁平化，主要的思路是：每次找到当前节点左子树的最右节点，然后将右子树连接到这个最右节点上，接着把左子树变成右子树，最后将左子树置 null。
//    该方法是通过模拟将树扁平化成链表的过程，实现了树的修改。

}
