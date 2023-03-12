package com.itsgm.inprogress.medium;

public class P31NextPermutation {

    class Solution {

        public void nextPermutation(int[] nums) {


            int p = nums.length - 1;
            int q = p; // last index from right, where subarray is sorted ACS (going from right)

            while (p - 1 >= 0 && nums[p - 1] > nums[p]) {
                q = p - 1;
            }

            if (q == 0) {
                reverse(nums, 0, nums.length - 1);
            } else {
                reverse(nums, q,  nums.length - 1);
                swap(nums, q, q-1);
            }

        }

    }

    //1,2,3

    void reverse(int[] nums, int from, int to) {
        int middle = (from + to) / 2;
        for (int i = from; i <= middle; i++) {
            swap(nums, i, nums.length - i);
        }
    }

    void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    //1,2,3,4,5,6
    //1,2,3,4,6,5
    //1,2,3,5,4,6
    //1,2,3,5,6,4
    //1,2,3,6,4,5
    //1,2,3,6,5,4

    //1,2,4,3,5,6
    //1,2,4,3,6,5
    //1,2,4,5,3,6
    //1,2,4,5,6,3
    //1,2,4,6,3,5
    //1,2,4,6,5,3

    //1,2,5,3,4,6
    //1,2,5,3,6,4
    //1,2,5,4,3,6
    //1,2,5,4,6,3
    //1,2,5,6,3,4
    //1,2,5,6,4,3

    //1,2,6,3,4,5
    //1,2,6,3,5,4
    //1,2,6,4,3,5
    //1,2,6,4,5,3
    //1,2,6,5,3,4
    //1,2,6,5,4,3

    //...

    //1,6,2,3,4,5
    //1,6,2,3,5,4
    //1,6,2,4,3,5
    //1,6,2,4,5,3
    //1,6,2,5,3,4

    //1,6,2,5,4,3
    //1,6,3,2,4,5
    //1,6,3,2,5,4
    //1,6,3,4,2,5
    //1,6,3,4,5,2
    //1,6,3,5,2,4
    //1,6,3,5,4,2

    //1,6,4,2,3,5
    //1,6,4,2,5,3
    //1,6,4,3,2,5
    //1,6,4,3,5,2
    //1,6,4,5,2,3
    //1,6,4,5,3,2

    //1,6,5,2,3,4
    //1,6,5,2,4,3
    //1,6,5,3,2,4
    //1,6,5,3,4,2
    //1,6,5,4,2,3
    //1,6,5,4,3,2

    //6,4,1,5,3,2
    //6,4,2,1,3,5

    //6,5,4,3,2,1
    //6,1,2,3,4,5

    //1. find max value from array
    //2. when elem with max value is on 1st position
    // 2.1 when all element on right from max are sorted - reverse array and return

    //3. else
    //


    //2. when all elements on right sorted in desc order
    // swap last (3) element with max (6)
    // swap


    //1,2,3,4
    //1,2,4,3
    //1,3,2,4
    //1,3,4,2
    //1,4,2,3
    //1,4,3,2
    //2,1,3,4
    //2,1,4,3
    //2,3,1,4
    //2,3,4,1
    //2,4,1,3
    //2,4,3,1
    //3,1,2,4
    //3,1,4,2
    //3,2,1,4
    //3,2,4,1
    //3,4,1,2
    //3,4,2,1
    //4,1,2,3
    //4,1,3,2
    //4,2,1,3
    //4,2,3,1
    //4,3,1,2
    //4,3,2,1
}
