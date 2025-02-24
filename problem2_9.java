package leetcode;

import java.util.*;

public class problem2_9 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        rotate2(nums,k);
        System.out.println(Arrays.toString(nums));
    }
    //方法一 暴力解法 使用空间复杂度为n
    public static void rotate(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList();
        int len = nums.length;

        for(int i=0; i<len; i++){
            list.add(nums[(i+k)%len]);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }
    //方法二数组翻转
    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        if(k>=len) k=k%len;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    private static void reverse(int[] nums, int l, int r) {

        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

}
