package com.itsgm.done.medium;

import java.util.List;

//https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
public class P1428LeftmostColumnWithAtLeastAOne_fast {


    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    }


    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

            List<Integer> dimensions = binaryMatrix.dimensions();
            int rows = dimensions.get(0);
            int columns = dimensions.get(1);

            int r = 0;
            int c = columns;

            while (r < rows) {

                //go left
                while (c - 1 >= 0 && binaryMatrix.get(r, c - 1) == 1) {
                    c--;
                }
                if (c == 0) {
                    return 0;
                }

                // go down
                r++;
            }
            return c != columns ? c : -1;
        }

    }
}
