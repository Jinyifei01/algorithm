package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem2_24 {
    //递归算法
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }


    //使用栈来操作
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> res1 = new ArrayList<Integer>();
        TreeNode cur = root;
        while (!stack.isEmpty()||cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res1.add(cur.val);
            cur = cur.right;
        }

        return res1;
    }


}
