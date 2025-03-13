package leetcode;

public class problem3_10_4 {
//
//    给你一个满足下述两条属性的 m x n 整数矩阵：
//
//    每行中的整数从左到右按非严格递增顺序排列。
//    每行的第一个整数大于前一行的最后一个整数。
//    给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(target<=matrix[i][matrix[i].length-1]){
//                for (int j = 0; j < matrix[i].length; j++) {
//                    if(matrix[i][j]==target){
//                        return true;
//                    }
//                }
//                return false;
                return binarysearch(matrix[i],target);


            }
            if(i==matrix.length-1) return false;

        }
        return false;
    }

    private boolean binarysearch(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(matrix[mid]==target){
                return true;
            }else if(matrix[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return  false;
    }


//方法二看成是一个数组，进行二分查找
//    class Solution {
//        public boolean searchMatrix(int[][] matrix, int target) {
//            int m = matrix.length, n = matrix[0].length;
//            int low = 0, high = m * n - 1;
//            while (low <= high) {
//                int mid = (high - low) / 2 + low;
//                int x = matrix[mid / n][mid % n];
//                if (x < target) {
//                    low = mid + 1;
//                } else if (x > target) {
//                    high = mid - 1;
//                } else {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

}
