package leetcode;

import java.util.Arrays;

public class problem2_11 {
    public static void main(String[] args) {
        int[]nums = {3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(i);

    }
    //暴力解法O（nlogn）
    public static int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
        int min=1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 ) {
                continue;
            }
            else if (nums[i] == min) {

                min++;
            }
        }
        return min;
    }
    //方法二
    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }

        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;

    }
    public static void swap(int[] nums,int n,int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

}
