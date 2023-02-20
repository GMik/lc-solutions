package com.itsgm.inprogress.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println(kthLargest);

    }


    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            for (int i = 0; i < nums.length; i++) {

                if (priorityQueue.size() < k) {
                    priorityQueue.add(nums[i]);
                } else {
                    if (priorityQueue.peek() < nums[i]) {
                        priorityQueue.poll();
                        priorityQueue.add(nums[i]);
                    }
                }
            }
            return priorityQueue.poll();
        }
    }
}
