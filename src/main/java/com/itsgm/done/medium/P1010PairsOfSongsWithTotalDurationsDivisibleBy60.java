package com.itsgm.done.medium;

import java.math.BigInteger;

public class P1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

    class Solution {

        //[30,20,150,100,40]

        //30, 20, 30, 40, 40

        //20 - 1
        //30 - 2
        //40 - 2  n * (n-1)/ 2

        //0

        /**
         * For songs with reminder 0s or 30s (30s, 60s, 90s, 120s, ...)
         * 0 - 0                                                                                               == 0
         * 1 - 0                                                                                               == 0
         * 2 - 1                                                                                               == 1
         * 3 - 1+2, 2+3, 1+3                                                                                   == 3
         * 4 - 1+2, 1+3, 1+4, 2+3, 2+4, 3+4                                                                    == 6
         * 5 - 1,2 1,3, 1,4, 1,5, 2,3, 2,4, 2,5 3,4, 3,5 4,5                                                   == 10
         * 6 = 1,2 1,3, 1,4 1,5 1,6 2,3 2,4 2,5 2,6 3,4 3,5 3,6 4,5 4,6 5,6                                    == 15
         * <p>
         * ... n -> n*(n-1)/2
         */


        public int numPairsDivisibleBy60(int[] time) {

            int result = 0;
            int[] reminders = new int[60];

            for (int i = 0; i < time.length; i++) {

                reminders[time[i] % 60]++;
            }

            result += (pairsForReminderZeroOr30(reminders[0]));
            result += (pairsForReminderZeroOr30(reminders[30]));

            for (int i = 1; i < 30; i++) {
                result += (reminders[i] * reminders[60 - i]);
            }


            return result;

        }

        static final BigInteger TWO = BigInteger.valueOf(2);

        int pairsForReminderZeroOr30(int n) {
            int res = n * (n - 1) / 2;
            if (res > 0)
                return res;

            BigInteger n1 = new BigInteger(String.valueOf(n));
            BigInteger n2 = new BigInteger(String.valueOf(n - 1));
            BigInteger r = n1.multiply(n2).divide(TWO);
            return r.intValue();
        }
    }
}
