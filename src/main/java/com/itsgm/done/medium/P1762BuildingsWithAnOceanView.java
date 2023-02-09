package com.itsgm.done.medium;

public class P1762BuildingsWithAnOceanView {

    class Solution {
        public int[] findBuildings(int[] heights) {
            int len = heights.length;

            int max = 0;
            int counter = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (heights[i] > max) {
                    counter++;
                    max = heights[i];
                } else {
                    heights[i] = -1;
                }
            }

            int[] result = new int[counter];
            int k = 0;
            for (int i = 0; i < len; i++) {
                if (heights[i] > 0)
                    result[k++] = i;
            }

            return result;
        }
    }
}
