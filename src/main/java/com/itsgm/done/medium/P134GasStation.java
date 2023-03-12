package com.itsgm.done.medium;

public class P134GasStation {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int localSumOfDifferences = 0;
            int sumOfDifferences = 0;

            int index = 0;
            int diff = 0;

            for (int i = 0; i < gas.length; i++) {
                diff = gas[i] - cost[i];
                sumOfDifferences += diff;
                localSumOfDifferences += diff;

                if (localSumOfDifferences < 0) {
                    localSumOfDifferences = 0;
                    index = i + 1;
                }
            }

            if (sumOfDifferences < 0) {
                return -1;
            }

            return index;
        }
    }
}
