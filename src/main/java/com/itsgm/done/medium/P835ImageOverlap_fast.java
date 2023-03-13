package com.itsgm.done.medium;

public class P835ImageOverlap_fast {

    class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {
            int len = img1.length;
            int result = 0;

            int[][] shiftCounters = new int[2 * len + 1][2 * len + 1];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (img1[i][j] == 1) {
                        for (int i2 = 0; i2 < len; i2++) {
                            for (int j2 = 0; j2 < len; j2++) {
                                if (img2[i2][j2] == 1)
                                    shiftCounters[i - i2 + len][j - j2 + len]++;
                            }
                        }
                    }
                }
            }
            for (int[] rowCounters : shiftCounters) {
                for (int counter : rowCounters) {
                    result = Math.max(result, counter);
                }
            }
            return result;
        }

    }
}
