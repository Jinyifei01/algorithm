package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem3_3_2 {

    //使用层序遍历加入最后一个即可
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (root != null&& queue.size() > 0) {
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if(i==size-1) res.add(node.val);
            }


        }
        return res;
    }

//使用递归加入深度的最右边即可
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {

        int depth = 0;
        travel(root,depth);
        return result ;

    }

    public void travel(TreeNode root,int depth){
        if(root ==null) return;
        if(result.size() == depth){
            result.add(root.val);
        }

        travel(root.right,depth+1);
        travel(root.left,depth+1);

    }
}
