package leetcode;

public class problem3_15_4 {

    //路有多长 ，人走多远
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;


    }
}
