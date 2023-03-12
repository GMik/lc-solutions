package com.itsgm.done.medium;

public class P540SingleElementInASortedArray {

    static class Solution {

        public static void main(String[] args) {
            Solution solution = new Solution();
            int r = solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
            System.out.println(r);
        }

        public int singleNonDuplicate(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            }

            return singleNonDuplicate(nums, 0, nums.length - 1);
        }

        public int singleNonDuplicate(int[] nums, int start, int end) {

            int middle;
            while (true) {

                if (end - start == 2) {
                    return nums[start] == nums[start + 1] ? nums[end] : nums[start];
                }

                middle = (start + end) / 2;

                if (isNonDuplicate(nums, middle)) {
                    return nums[middle];
                } else {
                    if (middle % 2 == 0 && nums[middle] == nums[middle - 1]) {
                        end = middle;
                    } else if (middle % 2 == 1 && nums[middle] == nums[middle + 1]) {
                        end = middle - 1;
                    } else {
                        start = middle;
                    }
                }

            }
        }


        public boolean isNonDuplicate(int[] nums, int i) {
            if (i == 0) {
                return nums[i] != nums[i + 1];
            } else if (i == nums.length - 1) {
                return nums[i] != nums[i - 1];
            }

            boolean r = nums[i] != nums[i + 1] && nums[i] != nums[i - 1];
            return r;
        }
    }


}
