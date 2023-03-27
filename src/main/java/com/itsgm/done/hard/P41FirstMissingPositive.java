package com.itsgm.done.hard;

public class P41FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{10, 4, 16, 54, 17, -7, 21, 15, 25, 31, 61, 1, 6, 12, 21, 46, 16, 56, 54, 12, 23, 20, 38, 63, 2, 27, 35, 11, 13, 47, 13, 11, 61, 39, 0, 14, 42, 8, 16, 54, 50, 12, -10, 43, 11, -1, 24, 38, -10, 13, 60, 0, 44, 11, 50, 33, 48, 20, 31, -4, 2, 54, -6, 51, 6};
        int res = solution.firstMissingPositive(arr);
        System.out.println(res); //3
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {

            int minPositive = Integer.MAX_VALUE;
            int len = nums.length;

            if (nums.length == 1) {
                return nums[0] != 1 ? 1 : 2;
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) {
                    if (nums[i] > 0 && nums[i] < minPositive) {
                        minPositive = nums[i];
                    }
                } else {
                    nums[i] = Integer.MAX_VALUE;
                }
            }

            if (minPositive > 1) {
                return 1;
            }
            int maxAllowedPosition = nums.length - 1;


            for (int i = 0; i < len; i++) {
                int position = Math.abs(nums[i]) - minPositive;
                if (position <= maxAllowedPosition) {
                    nums[position] = -1 * Math.abs(nums[position]);
                }
            }

            int i = 0;
            int maxI = nums.length - 1;

            while (i <= maxI && nums[i] < 0) {
                i++;
            }

            return minPositive + i;


        }
    }
}