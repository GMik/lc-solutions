package com.itsgm.inprogress;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/set-intersection-size-at-least-two/
public class P757SetIntersectionSizeAtLeastTwo {

    public static void main(String[] args) {
        int[][] intervals = new int[4][];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{1, 4};
        intervals[2] = new int[]{2, 5};
        intervals[3] = new int[]{3, 5};

        Solution sol = new Solution();
        sol.intersectionSizeTwo(intervals);
    }

    static class Solution {

        public int intersectionSizeTwo(int[][] intervals) {

            if (intervals.length == 1) {
                return 2;
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
                }
            });
            Set<Integer> nums = new HashSet<>();
            boolean covered = false;
            int[] current = intervals[0];

            for (int i = 1; i < intervals.length - 1; i++) {

                int[] next = intervals[i];

                //like [0,4] and [6,8]
                if (getLast(current) < getFirst(next)) {

                    if (!covered) {
                        nums.add(getLastButOne(current));
                        nums.add(getLast(current));
                        covered = false;
                    }

                    current[0] = getLastButOne(next);
                    current[1] = getLast(next);
                } else if (getLast(current) == getFirst(next)) {
                    nums.add(getLastButOne(current));
                    nums.add(getLast(current));
                    nums.add(getLast(current) + 1);

                    current[0] = getLastButOne(next);
                    current[1] = getLast(next);

                    covered = true;
                } else {
                    current[0] = Math.min(getLast(current), getLast(next)) - 1;
                    current[1] = Math.min(getLast(current), getLast(next));
                }

            }

            if (getLast(current) < getFirst(intervals[intervals.length - 1])) {
                return nums.size() + 2;
            } else if (getLast(current) == getFirst(intervals[intervals.length - 1])) {
                return nums.size() + 1;
            }

            return nums.size();
        }

        private int getFirst(int[] interval) {
            return interval[0];
        }

        private int getLast(int[] interval) {
            return interval[1];
        }

        private int getLastButOne(int[] interval) {
            return interval[1] - 1;
        }


    }
}
