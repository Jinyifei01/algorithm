package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem3_10_2 {

    //n皇后问题
//    总结
//    算法：回溯法。
//    时间复杂度：O(n!)，因为需要尝试所有可能的排列，但剪枝（isValid）减少了无效尝试。
//    空间复杂度：O(n²) 用于存储棋盘，递归栈深度为 O(n)。
//    关键点：
//    使用 cur 表示当前棋盘状态，通过引用传递避免拷贝。
//    isValid 只检查上方，优化了检查逻辑。
//    回溯撤销（cur[level][j] = '.'）保证了状态恢复。
    private List<List<String>> res = new ArrayList<>(); // 存储所有有效解

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘，每一行是一个长度为 n 的字符串，初始为 "."
        List<String> cur = new ArrayList<>();
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            row[i] = '.';
        }
        String rowStr = new String(row);
        for (int i = 0; i < n; i++) {
            cur.add(rowStr);
        }

        backtracking(cur, 0, n);
        return res;
    }

    private void backtracking(List<String> cur, int level, int n) {
        // 如果所有行都放置了皇后，记录当前解
        if (level == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int j = 0; j < n; j++) {
            if (isValid(cur, level, j)) {
                // 将当前行的第 j 列设置为 'Q'
                char[] rowChars = cur.get(level).toCharArray();
                rowChars[j] = 'Q';
                cur.set(level, new String(rowChars));

                backtracking(cur, level + 1, n);

                // 回溯：撤销放置
                rowChars[j] = '.';
                cur.set(level, new String(rowChars));
            }
        }
    }

    private boolean isValid(List<String> cur, int i, int j) {
        int n = cur.size();

        // 检查上方列
        for (int a = 0; a < n; a++) {
            if (cur.get(a).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上对角线
        for (int a = i, b = j; a >= 0 && b >= 0; a--, b--) {
            if (cur.get(a).charAt(b) == 'Q') {
                return false;
            }
        }

        // 检查右上对角线
        for (int a = i, b = j; a >= 0 && b < n; a--, b++) {
            if (cur.get(a).charAt(b) == 'Q') {
                return false;
            }
        }

        return true; // 如果没有冲突，返回 true
    }
}
