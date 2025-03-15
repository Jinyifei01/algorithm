package leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem2_13 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println(spiralOrder);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int L = 0, R = n - 1, T = 0, B = m - 1, i = -1, j = 0;
        List<Integer> res = new ArrayList<>();
        while (L <= R && T <= B) {
            while (++i <= R) res.add(matrix[j][i]);
            T++; i--;
            while (++j <= B) res.add(matrix[j][i]);
            R--; j--;
            while (--i >= L && res.size() < m * n) res.add(matrix[j][i]);
            B--; i++;
            while (--j >= T && res.size() < m * n) res.add(matrix[j][i]);
            L++; j++;
        }
        return res;
    }
}
