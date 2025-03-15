package leetcode;

public class problem3_9_4 {
//本问题是典型的回溯问题，需要使用深度优先搜索（DFS）+ 剪枝解决。
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }




}
