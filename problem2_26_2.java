package leetcode;

import java.util.*;

public class problem2_26_2 {

    //广度优先遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    //深度优先遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {return results;}
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        return new ArrayList(map.values());
    }

    public void helper(TreeNode root, Integer level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return ;
        }
        if (map.get(level) == null) {
            map.put(level, new ArrayList<Integer>());
        }
        List<Integer> list = map.get(level);
        list.add(root.val);

        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);
    }
}
