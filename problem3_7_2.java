package leetcode;

public class problem3_7_2 {

//寻找岛屿面积的最大值
//    public int maxAreaOfIsland(int[][] grid) {
//        int res = 0;
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                if (grid[r][c] == 1) {
//                    int a = area(grid, r, c);
//                    res = Math.max(res, a);
//                }
//            }
//        }
//        return res;
//    }
//
//    int area(int[][] grid, int r, int c) {
//        if (!inArea(grid, r, c)) {
//            return 0;
//        }
//        if (grid[r][c] != 1) {
//            return 0;
//        }
//        grid[r][c] = 2;
//
//        return 1
//                + area(grid, r - 1, c)
//                + area(grid, r + 1, c)
//                + area(grid, r, c - 1)
//                + area(grid, r, c + 1);
//    }
//
//    boolean inArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length
//                && 0 <= c && c < grid[0].length;
//    }



    //计算岛屿周长
//    public int islandPerimeter(int[][] grid) {
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                if (grid[r][c] == 1) {
//                    // 题目限制只有一个岛屿，计算一个即可
//                    return dfs(grid, r, c);
//                }
//            }
//        }
//        return 0;
//    }
//
//    int dfs(int[][] grid, int r, int c) {
//        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
//        if (!inArea(grid, r, c)) {
//            return 1;
//        }
//        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
//        if (grid[r][c] == 0) {
//            return 1;
//        }
//        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
//        if (grid[r][c] != 1) {
//            return 0;
//        }
//        grid[r][c] = 2;
//        return dfs(grid, r - 1, c)
//                + dfs(grid, r + 1, c)
//                + dfs(grid, r, c - 1)
//                + dfs(grid, r, c + 1);
//    }
//
//    // 判断坐标 (r, c) 是否在网格中
//    boolean inArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length
//                && 0 <= c && c < grid[0].length;
//    }
//
//


    //计算岛屿数量
//    public int numIslands(char[][] grid) {
//        int sum = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    reset(grid,i,j);
//                    sum++;
//                }
//            }
//
//        }
//    }
//
//    private void reset(char[][] grid, int i, int j) {
//        if(!right(grid,i,j)) return;
//        if(grid[i][j] != '1') return;
//        grid[i][j] = '2';
//        reset(grid,i-1,j);
//        reset(grid,i+1,j);
//        reset(grid,i,j-1);
//        reset(grid,i,j+1);
//    }
//
//    private boolean right(char[][] grid,int i, int j) {
//        return (i<grid.length-1) && (grid[0].length-1 >j) &&(i>0)&&(j>0);
//    }

}
