package leetcode;

public class problem3_10_3 {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 5;
        problem3_10_3 p = new problem3_10_3();
        System.out.println(p.searchInsert(nums,target));
    }
    //暴力查找
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            }else if (nums[i]>target){
                return i;
            }

        }
        return nums.length;
    }

    //二分查找
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

}
