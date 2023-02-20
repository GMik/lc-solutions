package com.itsgm.inprogress.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    class Solution {


        public int minDifference(int[] nums) {

            if (nums.length < 5) {
                return 0;
            }

            PriorityQueue<Integer> fromBottom = new PriorityQueue<>();
            PriorityQueue<Integer> fromTop = new PriorityQueue<>(Collections.reverseOrder());

            int len = nums.length;
            for (int i = 0; i < len; i++) {
                fromBottom.offer(nums[i]);
                fromTop.offer(nums[i]);

                if (fromBottom.size() > 4)
                    fromBottom.poll();

                if (fromTop.size() > 4)
                    fromTop.poll();

            }

            int[] ends = new int[8];
            for (int i = 0; i < 4; i++) {
                ends[i] = fromBottom.poll();
                ends[8 - i] = fromTop.poll();
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                res = Math.min(res, ends[8 - (4 - i)] - ends[i]);
            }
            return res;

        }
    }

}
