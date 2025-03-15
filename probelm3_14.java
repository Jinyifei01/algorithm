package leetcode;

import java.util.Arrays;

public class probelm3_14 {


    //快速选择 快速排序的核心包括“哨兵划分” 和 “递归” 。
//    public class Solution {
//        private int quickSelect(List<Integer> nums, int k) {
//            // 随机选择基准数
//            Random rand = new Random();
//            int pivot = nums.get(rand.nextInt(nums.size()));
//            // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
//            List<Integer> big = new ArrayList<>();
//            List<Integer> equal = new ArrayList<>();
//            List<Integer> small = new ArrayList<>();
//            for (int num : nums) {
//                if (num > pivot)
//                    big.add(num);
//                else if (num < pivot)
//                    small.add(num);
//                else
//                    equal.add(num);
//            }
//            // 第 k 大元素在 big 中，递归划分
//            if (k <= big.size())
//                return quickSelect(big, k);
//            // 第 k 大元素在 small 中，递归划分
//            if (nums.size() - small.size() < k)
//                return quickSelect(small, k - nums.size() + small.size());
//            // 第 k 大元素在 equal 中，直接返回 pivot
//            return pivot;
//        }
//
//        public int findKthLargest(int[] nums, int k) {
//            List<Integer> numList = new ArrayList<>();
//            for (int num : nums) {
//                numList.add(num);
//            }
//            return quickSelect(numList, k);
//        }
//    }





    //使用推排序
//    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            int heapSize = nums.length;
//            buildMaxHeap(nums, heapSize);
//            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//                swap(nums, 0, i);
//                --heapSize;
//                maxHeapify(nums, 0, heapSize);
//            }
//            return nums[0];
//        }
//
//        public void buildMaxHeap(int[] a, int heapSize) {
//            for (int i = heapSize / 2 - 1; i >= 0; --i) {
//                maxHeapify(a, i, heapSize);
//            }
//        }
//
//        public void maxHeapify(int[] a, int i, int heapSize) {
//            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
//            if (l < heapSize && a[l] > a[largest]) {
//                largest = l;
//            }
//            if (r < heapSize && a[r] > a[largest]) {
//                largest = r;
//            }
//            if (largest != i) {
//                swap(a, i, largest);
//                maxHeapify(a, largest, heapSize);
//            }
//        }
//
//        public void swap(int[] a, int i, int j) {
//            int temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//        }
//    }


}
