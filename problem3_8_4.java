package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem3_8_4 {

    //使用0-1方法
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 结果列表，用来存储所有子集
        for (int i = 0; i < (1 << nums.length); i++) {  // 枚举所有的子集，1 << nums.length 表示 2^nums.length
            List<Integer> sub = new ArrayList<Integer>(); // 存储当前的子集
            for (int j = 0; j < nums.length; j++) {  // 遍历每个元素
                //这里将 i 右移 j 位，然后与 1 做按位与操作，判断 i 的第 j 位是否为 1。如果是 1，
                // 表示 nums[j] 这个元素应该包含在当前子集中。
                if (((i >> j) & 1) == 1)  // 如果第 j 位为 1，则将 nums[j] 加入当前子集
                    sub.add(nums[j]);
            }
            res.add(sub); // 将当前子集添加到结果中
        }
        return res;  // 返回结果
    }








    //递归利用全排列进行改编
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTracking(nums, 0, new ArrayList<>());
        return res;
    }

    public void backTracking(int[] nums,int index,List<Integer> list) {
        //任何一个能进入递归的都一定是一个正确的集合，因为源数组每个元素都不相同，并且1只能和2或3组成集合,2只能和3组成集合,3只能和自己，所以进入的一定是唯一的
        res.add(new ArrayList<>(list));
        //按层遍历
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums,i+1,list);//递归
            list.remove(list.size()-1);//回溯
        }
    }
}
