package com.itsgm.done.hard;

public class P135Candy {

    public static class Solution {

        public int candy(int[] ratings) {

            if (ratings.length <= 1) {
                return ratings.length;
            }

            int candies = 0;

            // those do not include peak element
            int up = 0;
            int down = 0;

            //number of subsequent elements which were falling or raising
            int oldSlope = 0;

            for (int i = 1; i < ratings.length; i++) {

                // compare current element with previous
                int newSlope = Integer.compare(ratings[i], ratings[i - 1]);


                // if end of raising slope (was raising, but found two elements with equal score
                // OR end of falling (was falling, but new element is equal or greater than previous)
                if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {

                    // one of (up, down) will always be 0 (?)
                    candies += countCandies(up)
                            + countCandies(down)
                            + Math.max(up, down);

                    up = 0;
                    down = 0;
                }

                if (newSlope > 0) {
                    up++;
                } else if (newSlope < 0) {
                    down++;
                } else {
                    candies++;
                }

                oldSlope = newSlope;
            }

            candies += countCandies(up)
                    + countCandies(down)
                    + Math.max(up, down) + 1;

            return candies;
        }

        // sub-distributions always take form 1,2,3,..., n (or n,...,3,2,1)
        // so it can be generalised with formula: n(n+1)/2
        public int countCandies(int n) {
            return (n * (n + 1)) / 2;
        }
    }


    // greedy, faster than above, similar to trapping water
    class Solution2 {
        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];


            // initialize with 1
            for (int i = 0; i < candies.length; ++i) {
                candies[i] = 1;
            }

            // going from left (n) to right (m), when right has higher score than left, set its
            // value to = left+1
            for (int i = 1; i < candies.length; ++i) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // going from right (m) to left (n), when left has higher score than right and candies
            // for left is smaller than candies for right plus 1 -> update candies
            for (int i = candies.length - 2; i >= 0; --i) {
                if (ratings[i] > ratings[i + 1] && candies[i] < candies[i + 1] + 1) {
                    candies[i] = candies[i + 1] + 1;
                }
            }

            // sum up all candies
            int sum = 0;
            for (int i = 0; i < candies.length; ++i) {
                sum += candies[i];
            }
            return sum;
        }
    }
}
