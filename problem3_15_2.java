package leetcode;

public class problem3_15_2 {
//
//    这段代码通过使用两个堆（小顶堆和大顶堆）来维护数据流的中位数。通过在添加元素时维护两堆的平衡，
//    确保了中位数可以在O(1)时间复杂度内找到，添加操作的时间复杂度为O(log n)。这种方法高效且直观，是解决动态中位数问题的经典方法。
//    class MedianFinder {
//        Queue<Integer> A, B;
//        public MedianFinder() {
//            A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
//            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
//        }
//        public void addNum(int num) {
//            if (A.size() != B.size()) {
//                A.add(num);
//                B.add(A.poll());
//            } else {
//                B.add(num);
//                A.add(B.poll());
//            }
//        }
//        public double findMedian() {
//            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
//        }
//    }
}
