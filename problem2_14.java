package leetcode;

import java.util.Arrays;

public class problem2_14 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate2(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    //暴力方法 使用数组存储数组 找出连个数组规律即可
    public static void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        //System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //(0,0) (0,1) (0,2) ->(0,2) (1,2) (2,2)
                temp[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    //方法二 原地转换 在替换时使用temp存储被替换的值 四次一循环
    public static void rotate2(int[][] matrix) {
        //temp[j][matrix.length-1-i]=matrix[i][j];
        //temp[matrix.length-1-i][matrix.length-1-j]=matrix[j][matrix.length-1-i];
        //temp[matrix.length-1-i][i]=matrix[matrix.length-1-i][matrix.length-1-j];
        //temp[i][j]=matrix[matrix.length-1-i][i];
//        当n为偶数时，我们需要枚举n^2/4=(n/2)×(n/2)个位置，可以将该图形分为四块，以 4×4 的矩阵为例：2×3
        // n为奇数时，以5×5为例：2×3
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix[0].length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;


            }
        }
    }

    //方法三 另辟蹊径，用翻转操作代替旋转操作。
    public static void rotate3(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }

}
