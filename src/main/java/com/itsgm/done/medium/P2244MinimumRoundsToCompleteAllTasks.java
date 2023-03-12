package com.itsgm.done.medium;

import java.util.Arrays;

public class P2244MinimumRoundsToCompleteAllTasks {

    class Solution {
        public int minimumRounds(int[] tasks) {

            if(tasks.length == 1){
                return -1;
            }

            int result = 0;

            Arrays.sort(tasks);

            int previous = 0;
            int previousCounter = 0;
            int current = 0;
            for (int i = 0; i < tasks.length; i++) {

                // take next item
                current = tasks[i];

                // when it is not equal to current (last) value
                if (current != previous) {

                    // when only one occurence - return -1
                    if (previousCounter == 1) {
                        return -1;
                    } else {
                        //update result
                        result += roundToCompleteTask(previousCounter);
                    }
                    previous = current;
                    previousCounter = 1;

                } else {
                    previousCounter++;
                }
            }

            if (previousCounter == 1) {
                return -1;
            } else {
                result += roundToCompleteTask(previousCounter);
            }

            return result;
        }

        public int roundToCompleteTask(int occurrences) {
            return occurrences / 3 + (occurrences % 3 == 0 ? 0 : 1);
        }
        /**
         *  2 - 1
         *  3 - 1 ---------------------
         *  4 - 2 (2x2)   if (n mod3 == 1) ->
         *  5 - 2 (3, 2)
         *  6 - 2 (6/3) ----------------
         *  7 - 3 (3, 2, 2)
         *  8 - 3 (3, 3, 2)
         *  9 - 3 (9/3) ---------------
         *  10- 4 (3, 3, 2, 2)
         *  11- 4 (3, 3, 3, 2)
         *  12- 4 ---------------------
         *  13- 5 (3, 3, 3, 2, 2)
         *  14- 5 (3, 3, 3, 3, 2)
         *  15 -5 (3, 3, 3, 3, 3)
         */



    }
}
