package leetcode;

import java.util.*;

public class problem3_15 {
    //回家等通知写法
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }


    //使用最小堆
    public int[] topKFrequent2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
//        // 遍历map，用最小堆保存频率最大的k个元素
//        这里创建了一个PriorityQueue，并提供了一个自定义的比较器。
//        比较器的逻辑是：map.get(a) - map.get(b)，即比较两个元素的频率。
//        由于PriorityQueue默认是最小堆，比较器返回正数时，a会被排在b后面。因此，堆顶将是当前堆中频率最小的元素。
        PriorityQueue<Integer> pq = new PriorityQueue<>(( a,  b) ->map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int [] ans=new int[k];
        int i=0;
        while (!pq.isEmpty()) {
            ans[i]=pq.poll();
            i++;
        }

        return ans;
    }

    //基于桶排序求解「前 K 个高频元素」
//    class Solution {
//        public List<Integer> topKFrequent(int[] nums, int k) {
//            List<Integer> res = new ArrayList();
//            // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
//            HashMap<Integer,Integer> map = new HashMap();
//            for(int num : nums){
//                if (map.containsKey(num)) {
//                    map.put(num, map.get(num) + 1);
//                } else {
//                    map.put(num, 1);
//                }
//            }
//
//            //桶排序
//            //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
//            List<Integer>[] list = new List[nums.length+1];
//            for(int key : map.keySet()){
//                // 获取出现的次数作为下标
//                int i = map.get(key);
//                if(list[i] == null){
//                    list[i] = new ArrayList();
//                }
//                list[i].add(key);
//            }
//
//            // 倒序遍历数组获取出现顺序从大到小的排列
//            for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
//                if(list[i] == null) continue;
//                res.addAll(list[i]);
//            }
//            return res;
//        }
//    }


}
