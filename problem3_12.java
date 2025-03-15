package leetcode;

public class problem3_12 {


    public int findMin(int[] nums) {
        // 1.min初始值为第一段升序数组的最小值，而且目前不知道数组是有两段升序还是只有一段升序
        int min = nums[0];

        // 2.先正常二分查找
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            // 3.如果中间位置比min小，那么这个mid位置一定在第二段升序数组中，那么最小值一定在mid或者它的左边，这是因为每段都是升序的
            // 先更新min，然后向左边遍历
            if(nums[mid] < min){
                min = nums[mid];
                right = mid - 1;
            }
            // 4. 如果中间位置比min大，那么mid位置一定在第一段升序部分，因为第二段升序的最大值也要小于第一段升序的最小值
            // 所以直接向mid的右边遍历
            else {
                left = mid + 1;
            }
        }
        return min;
    }
}
