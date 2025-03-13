package leetcode;

import java.util.HashMap;
import java.util.Map;

public class problem3_6 {

    //使用递归的方法
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }




    //使用遍历的方法  没有搞懂



//    class Solution {
//        public:
//        TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
//            if (!preorder.size()) {
//                return nullptr;  // 如果前序遍历为空，则直接返回空树
//            }
//
//            TreeNode* root = new TreeNode(preorder[0]);  // 根节点就是前序遍历的第一个元素
//            stack<TreeNode*> stk;  // 用栈来模拟递归过程
//            stk.push(root);  // 将根节点入栈
//            int inorderIndex = 0;  // 中序遍历的索引，开始时为0
//
//            // 从第二个元素开始遍历前序序列
//            for (int i = 1; i < preorder.size(); ++i) {
//                int preorderVal = preorder[i];  // 当前前序遍历值
//                TreeNode* node = stk.top();  // 栈顶是当前需要操作的节点
//
//                // 如果栈顶节点的值不等于当前中序序列中的值，说明当前节点应该是栈顶节点的左子节点
//                if (node->val != inorder[inorderIndex]) {
//                    node->left = new TreeNode(preorderVal);  // 构造左子树
//                    stk.push(node->left);  // 将左子树节点入栈
//                }
//                else {
//                    // 如果栈顶节点的值等于当前中序序列中的值，说明需要弹出栈顶节点
//                    while (!stk.empty() && stk.top()->val == inorder[inorderIndex]) {
//                        node = stk.top();  // 获取栈顶节点
//                        stk.pop();  // 弹出栈顶节点
//                        ++inorderIndex;  // 继续遍历中序序列
//                    }
//                    // 为当前节点构造右子树
//                    node->right = new TreeNode(preorderVal);
//                    stk.push(node->right);  // 将右子树节点入栈
//                }
//            }
//
//            return root;  // 返回构造好的树的根节点
//        }
//    };

}
