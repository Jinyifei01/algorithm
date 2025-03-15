package leetcode;

public class problem2_7 {
    public static void main(String[] args) {
        int [] nums={-2,3};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }
    //方法一 最小前缀和
    private static int maxSubArray(int[] nums) {
        int len = nums.length;
        int prefix=0;
        int pre_min=0;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            prefix = prefix + nums[i];
            ans = Math.max(ans, prefix-pre_min);
            pre_min = Math.min(pre_min, prefix);
        }

        return ans;
    }
    //方法二  如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。  动态规划
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
