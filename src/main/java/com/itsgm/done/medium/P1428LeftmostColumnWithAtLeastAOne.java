package com.itsgm.done.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
public class P1428LeftmostColumnWithAtLeastAOne {

    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    }

    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

            List<Integer> dimensions = binaryMatrix.dimensions();
            int i = dimensions.get(0);
            int j = dimensions.get(1);

            List<Integer> initialRows = filterWithOne(binaryMatrix, i, j - 1);
            if (initialRows.size() == 0) {
                return -1;
            }

            return binarySearch(binaryMatrix, initialRows, 0, j - 1);

        }

        // for len = 10 -> [start =0. end = 9]
        public int binarySearch(BinaryMatrix binaryMatrix, List<Integer> rows, int start, int end) {

            int res = end;

            //0, 9 -> m=4
            //0,1,2,3,4,5,6,7,8,9

            //0,1,2,3 ->m=1

            while (start < end) {

                int middle = (start + end) / 2; // 4
                List<Integer> forMiddle = filterWithOne(binaryMatrix, rows, middle);

                if (forMiddle.size() == 0) {
                    start = middle + 1;

                } else {
                    end = middle;
                    res = middle;
                }

            }
            return res;
        }


        public List<Integer> filterWithOne(BinaryMatrix binaryMatrix, List<Integer> rows, int column) {
            return rows.stream().filter(r -> binaryMatrix.get(r, column) == 1).collect(Collectors.toList());
        }

        public List<Integer> filterWithOne(BinaryMatrix binaryMatrix, int size, int column) {
            List<Integer> result = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (binaryMatrix.get(i, column) == 1) {
                    result.add(i);
                }
            }
            return result;
        }
    }


}
