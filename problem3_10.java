package leetcode;

public class problem3_10 {


    //该方法通过DFS系统地探索所有可能的分割方式，并在每次分割时检查是否形成回文子串，从而确保所有
    // 分割结果满足条件。尽管其时间复杂度较高，但对于实际应用中的大多数字符串，这种方法是高效且可行的。
//    private final List<List<String>> ans = new ArrayList<>();
//    private final List<String> path = new ArrayList<>();
//    private String s;
//
//    public List<List<String>> partition(String s) {
//        this.s = s;
//        dfs(0, 0);
//        return ans;
//    }
//
//    // DFS方法：i 表示当前处理的位置，start 表示当前回文子串的起始位置
//    private void dfs(int i, int start) {
//        if (i == s.length()) { // 处理完整个字符串
//            ans.add(new ArrayList<>(path)); // 将当前路径添加到结果中
//            return;
//        }
//
//        // 不选 i 和 i+1 之间的逗号，继续处理 i+1 位置
//        if (i < s.length() - 1) {
//            dfs(i + 1, start);
//        }
//
//        // 选 i 和 i+1 之间的逗号，形成一个回文子串
//        if (isPalindrome(start, i)) {
//            path.add(s.substring(start, i + 1));
//            dfs(i + 1, i + 1); // 处理下一个位置
//            path.remove(path.size() - 1); // 回溯，移除最后一个子串
//        }
//    }
//
//    // 检查 s[start..i] 是否为回文
//    private boolean isPalindrome(int left, int right) {
//        while (left < right) {
//            if (s.charAt(left++) != s.charAt(right--)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
