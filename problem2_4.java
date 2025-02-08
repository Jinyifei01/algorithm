package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class problem2_4 {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1,1,5,6};
        int k=6;
        long startTime = System.currentTimeMillis();
        int sum = subarraySum(nums, k);
        long endTime = System.currentTimeMillis();
        System.out.println( sum );
        System.out.println( endTime - startTime );
        long startTime2 = System.currentTimeMillis();
        int sum2 = subarraySum2(nums, k);
        long endTime2 = System.currentTimeMillis();
        System.out.println(sum2 );
        System.out.println( endTime2 - startTime2 );
    }
    //解法二 前缀和与哈希表
    private static int subarraySum2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

    //解法一 暴力解法
    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;

                }
            }

        }
        return count;
    }


}
