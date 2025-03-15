package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem3_9_3 {
    //生成括号  暴力法 回溯法 生成所有括号检验合法性

        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c: current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }


    //回溯法 为每次递归增加条件

        public List<String> generateParenthesis2(int n) {
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }

// 代码随想录模板
//    class Solution {
//        StringBuffer path = new StringBuffer();
//        List<String> res = new ArrayList<>();
//
//        public List<String> generateParenthesis(int n) {
//            backtracking(0, 0, n);
//            return res;
//        }
//
//        void backtracking(int l, int r, int n) {
//            if (l > n || l < r) { // 剪枝
//                return;
//            }
//            if (path.length() == 2 * n) {
//                res.add(path.toString());
//            }
//            for (int i = 0; i < 2; i++) { // 将括号看作大小为 2 的数组，求他们的有效组合，括号个数决定了树的深度
//                if (i == 0) {
//                    path.append("(");
//                    backtracking(l + 1, r, n);
//                    path.deleteCharAt(path.length() - 1); // 回溯
//                }
//                if (i == 1) {
//                    path.append(")");
//                    backtracking(l, r + 1, n);
//                    path.deleteCharAt(path.length() - 1); // 回溯
//                }
//            }
//        }
//    }







}
