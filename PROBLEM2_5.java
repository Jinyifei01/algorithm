package leetcode;

import java.util.*;

public class PROBLEM2_5 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxSlidingWindow = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(maxSlidingWindow));

        int[] maxSlidingWindow2 = maxSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(maxSlidingWindow2));
        int[] maxSlidingWindow3 = maxSlidingWindow3(nums, k);
        System.out.println(Arrays.toString(maxSlidingWindow3));
    }
    //方法四 使用前缀最大值和后缀最大值相结合
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }




    //方法三 双端队列
    private static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0 ||nums.length<k) {return new int[0];}
        Deque<Integer> deque = new LinkedList<>();
        //初始化
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }


    //方法二使用优先队列
    private static int[] maxSlidingWindow2(int[] nums, int k) {
        //初始化
        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>( (o1,  o2)->o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new Integer[]{nums[i], i});
        }
        res[0] = pq.peek()[0];
        for (int i = k; i < nums.length ; i++) {
            pq.offer(new Integer[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    //方法一暴力解法
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            double max = -Math.pow(10, 4);
            for (int j = i; j - i < k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = (int) max;
        }
        return result;
    }
}
