package com.itsgm.done.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1001GridIllumination_slow {

    static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public static void main(String[] args) {
        Solution solution2 = new Solution();

        int n = 6;

        int[][] lamps = new int[][]{
                new int[]{2, 5},
                new int[]{4, 2},
                new int[]{0, 3},
                new int[]{0, 5},
                new int[]{1, 4},
                new int[]{4, 2},
                new int[]{3, 3},
                new int[]{1, 0},
        };

        int[][] queries = new int[][]{
                new int[]{4, 3},
                new int[]{3, 1},
                new int[]{5, 3},
                new int[]{0, 5},
                new int[]{4, 4},
                new int[]{3, 3}
        };

        int[] result = solution2.gridIllumination(n, lamps, queries);

        System.out.println(Arrays.toString(result));
    }

    static class Solution {

        //self (centre), upper-left, upper, upper-right, right, down-right, down, down-left, left
        private int[] indexesVertically = new int[]{0, -1, -1, -1, 0, 1, 1, 1, 0};
        private int[] indexesHorizontally = new int[]{0, -1, 0, 1, 1, 1, 0, -1, -1};


        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

            // initialize grid
            int[][] grid = new int[n][n];

            Set<Integer> lampsFields = new HashSet<>();

            // increase illumination basing on fields and store lamp coordinates in /illuminatedFields/
            changeIllumination(grid, lamps, n, lampsFields);

            //collect results, decreasing illumination in steps
            return collectResults(grid, queries, n, lampsFields);
        }

        public int[] collectResults(int[][] grid,
                                    int[][] queries,
                                    int n,
                                    Set<Integer> lampsFields) {

            int[] result = new int[queries.length];

            for (int k = 0; k < queries.length; k++) {

                int[] query = queries[k];

                int i = query[0];
                int j = query[1];

                result[k] = grid[i][j] > 0 ? 1 : 0;
                decreaseIllumination(i, j, n, grid, lampsFields);
            }

            return result;
        }

        public void changeIllumination(int[][] grid,
                                       int[][] lamps,
                                       int n,
                                       Set<Integer> lampsFields) {

            for (int i = 0; i < lamps.length; i++) {

                if (!lampsFields.contains(getAsInteger(lamps[i][0], lamps[i][1], n))) {
                    lampsFields.add(getAsInteger(lamps[i][0], lamps[i][1], n));
                    changeIlluminationByOne(grid, lamps[i][0], lamps[i][1], n, 1);
                }
            }
        }

        private int getAsInteger(int i, int j, int n) {
            return i * n + j;
        }

        public void decreaseIllumination(int i,
                                         int j,
                                         int n,
                                         int[][] grid,
                                         Set<Integer> lampsFields) {

            // only adjacent cells
            for (int k = 0; k < 9; k++) {
                int i_tmp = i + indexesVertically[k];
                int j_tmp = j + indexesHorizontally[k];

                // check that not outside borders
                if (inBoundaries(i_tmp, j_tmp, n)) {
                    if (lampsFields.contains(getAsInteger(i_tmp, j_tmp, n))) {
                        changeIlluminationByOne(grid, i_tmp, j_tmp, n, -1);
                        lampsFields.remove(getAsInteger(i_tmp, j_tmp, n));
                    }
                }
            }
        }

        public boolean inBoundaries(int i, int j, int len) {
            return i >= 0 && j >= 0 && i < len && j < len;
        }

        private void changeIlluminationByOne(int[][] grid,
                                             int initial_i,
                                             int initial_j,
                                             int n,
                                             int change) {

            grid[initial_i][initial_j] += change;

            //up
            int up = initial_i - 1;
            while (up >= 0) {
                grid[up][initial_j] += change;
                up--;
            }

            //down
            int down = initial_i + 1;
            while (down < n) {
                grid[down][initial_j] += change;
                down++;
            }

            //left
            int left = initial_j - 1;
            while (left >= 0) {
                grid[initial_i][left] += change;
                left--;
            }

            //right
            int right = initial_j + 1;
            while (right < n) {
                grid[initial_i][right] += change;
                right++;
            }

            //up-left
            up = initial_i - 1;
            left = initial_j - 1;
            while (up >= 0 && left >= 0) {
                grid[up][left] += change;
                up--;
                left--;
            }

            //up-right
            up = initial_i - 1;
            right = initial_j + 1;
            while (up >= 0 && right < n) {
                grid[up][right] += change;
                up--;
                right++;
            }

            //down-right
            down = initial_i + 1;
            right = initial_j + 1;
            while (down < n && right < n) {
                grid[down][right] += change;
                down++;
                right++;
            }

            //down-left
            down = initial_i + 1;
            left = initial_j - 1;
            while (down < n && left >= 0) {
                grid[down][left] += change;
                down++;
                left--;
            }

        }


    }

}
