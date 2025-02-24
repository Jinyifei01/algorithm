package leetcode;

import java.util.Arrays;

public class problem2_10 {
    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        int[] ints = productExceptSelf2(nums);
        System.out.println(Arrays.toString(ints));
    }
    //请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    //方法一 使用两个数组 分别记录左边数字的乘积和右边数字的乘积
    public static int[] productExceptSelf(int[] nums) {
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i]=left[i-1]*nums[i-1];
            right[nums.length-i-1]=right[nums.length-i]*nums[nums.length-i];

     }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=left[i]*right[i];
        }

        return nums;
    }
    //方法二 只使用一个数组
    public static int[] productExceptSelf2(int[] nums) {
        int[] left=new int[nums.length];
        left[0]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int r=1;
        for (int i = nums.length-1; i >=0; i--) {
            left[i]=left[i]*r;
            r=r*nums[i];
        }

        return left;
    }
    //双指针
//    int left = 0, right = nums.size() - 1;
//    int lp = 1, rp = 1;
//    while (right >= 0 && left < nums.size()) {
//        answer[right] *= rp;
//        answer[left] *= lp;
//        lp *= nums[left++];
//        rp *= nums[right--];
//    }
//    return answer;
}
