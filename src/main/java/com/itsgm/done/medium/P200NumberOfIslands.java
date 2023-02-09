package com.itsgm.done.medium;

//https://leetcode.com/problems/number-of-islands/description/
public class P200NumberOfIslands {

    class Solution {

        public int numIslands(char[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        clear(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void clear(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

            grid[i][j] = '0';
            clear(grid, i+1, j);
            clear(grid, i-1, j);
            clear(grid, i, j+1);
            clear(grid, i, j-1);
            return;
        }
    }
}
