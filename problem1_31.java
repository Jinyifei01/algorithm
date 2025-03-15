package leetcode;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class problem1_31 {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};

        int i = trap(height);
        System.out.println(i);

    }
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        int [] ans = new int[len];
        int count = 0;
        leftmax[0] = height[0];
        rightmax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftmax[i] = max(height[i],leftmax[i-1]);
        }
        for (int i = len-2; i >= 0; i--) {
            rightmax[i] = max(height[i],rightmax[i+1]);
        }
        for (int i = 0; i < len; i++) {
            ans[i]=min(leftmax[i],rightmax[i])-height[i];
            count=count+ans[i];

        }
        return count;

    }
}
