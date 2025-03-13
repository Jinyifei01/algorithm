package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class problem3_13_4 {

    //暴力解法
//    public class Solution {
//
//        public int largestRectangleArea(int[] heights) {
//            int len = heights.length;
//            // 特判
//            if (len == 0) {
//                return 0;
//            }
//
//            int res = 0;
//            for (int i = 0; i < len; i++) {
//
//                // 找左边最后 1 个大于等于 heights[i] 的下标
//                int left = i;
//                int curHeight = heights[i];
//                while (left > 0 && heights[left - 1] >= curHeight) {
//                    left--;
//                }
//
//                // 找右边最后 1 个大于等于 heights[i] 的索引
//                int right = i;
//                while (right < len - 1 && heights[right + 1] >= curHeight) {
//                    right++;
//                }
//
//                int width = right - left + 1;
//                res = Math.max(res, width * curHeight);
//            }
//            return res;
//        }
//    }





//以空间换时间，可以使用的数据结构是栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }





}
