package leetcode;

public class problem3_15_5 {

    //反向贪心每次寻找下标最小的位置，即为总的最小值
    public int jump(int[] nums) {
        int position = nums.length-1;
        int step=0;
        while(position>0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }


    //正向跳跃过程
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;//边界条件
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {//已达到边界 必须要跳跃
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
