package com.itsgm.done.medium;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };


        solution.spiralOrder(
                matrix
        );
    }

    static class Solution {

//        public List<Integer> spiralOrder(int[][] matrix) {
//
//            List<Integer> result = new ArrayList<>();
//
//            int right = matrix[0].length - 1;
//            int down = matrix.length - 1;
//            int left = right;
//            int up = down - 1;
//
//            int counter = 0;
//            int expectedCounter = matrix.length * matrix[0].length;
//
//            int rightCounter;
//            int downCounter;
//            int leftCounter;
//            int upCounter;
//
//            int i = 0;
//            int j = 0;
//
//            while (counter < expectedCounter-1) {
//
//                rightCounter = right;
//                downCounter = down;
//                leftCounter = left;
//                upCounter = up;
//
//                while (rightCounter-- > 0) {
//                    result.add(matrix[i][j++]);
//                    counter++;
//                }
//
//                while (downCounter-- > 0) {
//                    result.add(matrix[i++][j]);
//                    counter++;
//                }
//
//                while (leftCounter-- > 0) {
//                    result.add(matrix[i][j--]);
//                    counter++;
//                }
//
//                while (upCounter-- > 0) {
//                    result.add(matrix[i--][j]);
//                    counter++;
//                }
//
//                right -= 2;
//                down -= 2;
//                left -= 2;
//                up -= 2;
//            }
//
//            result.add(matrix[i][j]);
//
//            return result;
//        }
//


        public List<Integer> spiralOrder(int[][] matrix) {

            int capacity = matrix[0].length * matrix.length;
            List<Integer> res = new ArrayList<>(capacity);

            int[][] directions = new int[][]{
                    new int[]{0, 1},
                    new int[]{1, 0},
                    new int[]{0, -1},
                    new int[]{-1, 0},
            };

            int i = 0;
            int j = -1;
            int direction = 0;
            while (capacity > 0) {

                if (isOutsideMatrixOrVisited(i + directions[direction][0], j + directions[direction][1], matrix)) {
                    direction = (direction + 1) % 4;
                } else {
                    i = i + directions[direction][0];
                    j = j + directions[direction][1];
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    capacity--;
                }
            }

            return res;
        }

        public boolean isOutsideMatrixOrVisited(int i, int j, int[][] matrix) {
            return i < 0 || j < 0
                    || i >= matrix.length
                    || j >= matrix[0].length
                    || matrix[i][j] == -101;
        }

    }
}
