package leetcode;

import java.util.Arrays;

public class problem2_16 {
    public static void main(String[] args) {
        int [][] matix={{-1,3}};
        int target =3;
        boolean b = searchMatrix(matix, target);
        System.out.println(b);
        boolean b1 = searchMatrix2(matix, target);
        System.out.println(b1);
    }
    //对于每一行都使用二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int i1 = Arrays.binarySearch(matrix[i], target);
            if (i1 >= 0) return true;
        }
        return false;
    }
    //方法二 使用z字形查找
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else i++;
        }
        return false;
    }
}
