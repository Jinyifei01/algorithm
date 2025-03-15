package leetcode;


import java.util.ArrayList;
import java.util.Arrays;

public class problem2_8 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge1(intervals);
        System.out.println(Arrays.deepToString(ans));
        System.out.println(Arrays.deepToString(intervals));
    }
    //合并数组
    private static int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals,(o1,  o2) ->o1[0]-o2[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        int l, r;
        for (int i = 0; i < intervals.length; i++) {
            l = intervals[i][0];
            r = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < l) {
                ans.add(new int[]{l,r});
            }
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size()-1)[1], r);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
