package com.itsgm.done.hard;

import java.util.*;

public class P1001GridIllumination {

    static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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

        int[] result = solution.gridIllumination(n, lamps, queries);

        System.out.println(Arrays.toString(result));
    }


    static class Solution {

        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

            int[] indexesVertically = new int[]{0, -1, -1, -1, 0, 1, 1, 1, 0};
            int[] indexesHorizontally = new int[]{0, -1, 0, 1, 1, 1, 0, -1, -1};

            Map<Integer, Integer> horCounters = new HashMap<>();
            Map<Integer, Integer> vertCounters = new HashMap<>();
            Map<Integer, Integer> fallingDiagonalCounters = new HashMap<>();
            Map<Integer, Integer> raisingDiagonalCounters = new HashMap<>();
            Map<Integer, Boolean> lampsStatuses = new HashMap<>();

            for (int k = 0; k < lamps.length; k++) {

                int vert = lamps[k][0];
                int hor = lamps[k][1];

                int key = n * vert + hor;

                if (lampsStatuses.containsKey(key)) {
                    continue;
                }

                horCounters.put(hor, horCounters.getOrDefault(hor, 0) + 1);
                vertCounters.put(vert, vertCounters.getOrDefault(vert, 0) + 1);
                fallingDiagonalCounters.put(vert - hor, fallingDiagonalCounters.getOrDefault(vert - hor, 0) + 1);
                raisingDiagonalCounters.put(hor + vert, raisingDiagonalCounters.getOrDefault(hor + vert, 0) + 1);
                lampsStatuses.put(key, true);
            }

            int[] result = new int[queries.length];
            for (int k = 0; k < queries.length; k++) {

                int vert = queries[k][0];
                int hor = queries[k][1];

                result[k] = vertCounters.getOrDefault(vert, 0) > 0
                        || horCounters.getOrDefault(hor, 0) > 0
                        || fallingDiagonalCounters.getOrDefault(vert - hor, 0) > 0
                        || raisingDiagonalCounters.getOrDefault(vert + hor, 0) > 0 ? 1 : 0;

                for (int i = 0; i < 9; i++) {

                    int vertDiff = indexesVertically[i];
                    int horDiff = indexesHorizontally[i];

                    int vertApplied = vert + vertDiff;
                    int horApplied = hor + horDiff;

                    int key = n * vertApplied + horApplied;

                    Boolean keyPresent = lampsStatuses.get(key);

                    if (keyPresent != null && keyPresent) {
                        horCounters.put(horApplied, horCounters.getOrDefault(horApplied, 0) - 1);
                        vertCounters.put(vertApplied, vertCounters.getOrDefault(vertApplied, 0) - 1);
                        fallingDiagonalCounters.put(vertApplied - horApplied, fallingDiagonalCounters.getOrDefault(vertApplied - horApplied, 0) - 1);
                        raisingDiagonalCounters.put(horApplied + vertApplied, raisingDiagonalCounters.getOrDefault(horApplied + vertApplied, 0) - 1);

                        lampsStatuses.put(key, false);

                    }
                }

            }

            return result;
        }
    }

}
