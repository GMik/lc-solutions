package com.itsgm.done.medium;

public class P695MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res, maxArea(grid ,i, j));
            }
        }

        return res;
    }

    public int maxArea(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;

        return 1
                + (i - 1  >= 0? maxArea(grid, i - 1, j) : 0)
                + (i + 1 < grid.length ? maxArea(grid, i + 1, j) : 0)
                + (j - 1 >= 0 ? maxArea(grid, i, j - 1) : 0)
                + (j + 1 < grid[i].length ? maxArea(grid, i, j + 1) : 0);
    }
}
