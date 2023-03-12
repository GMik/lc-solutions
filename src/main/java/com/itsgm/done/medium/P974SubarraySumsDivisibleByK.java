package com.itsgm.done.medium;

import java.util.HashMap;
import java.util.Map;

public class P974SubarraySumsDivisibleByK {

    public static void main(String[] args) {


        class Solution {

            //fastest solution: with prefix sums -> arr contains prefix sums;  when reminder from arr[0, i] is the same as reminder from arr[0, j], then arr[i,j] can be divided by k
            //with reminder = 0
            public int subarraysDivByK(int[] nums, int k) {

                int sum = 0;
                int res = 0;
                int[] prefixSums = new int[k];

                prefixSums[0] = 1;

                for (int i = 0; i < nums.length; i++) {
                    sum = (sum + nums[i]) % k;

                    if (sum < 0)
                        sum += k;

                    res += prefixSums[sum]++;

                }
                return res;
            }


            public int subarraysDivByK3(int[] nums, int k) {

                int n = nums.length;
                int res = 0;

                for (int i = 0; i < n; i++) {

                    int sum = 0;
                    for (int j = i; j < n; j++) {
                        sum += nums[j];
                        if (sum % k == 0) {
                            res++;
                        }
                    }
                }
                return res;

            }

            public int subarraysDivByK2(int[] nums, int k) {

                int n = nums.length;
                int[][] cache = new int[n][n];

                int counter = 0;

                // length of subarray
                for (int len = 1; len <= n; len++) {

                    for (int i = 0; i + len <= n; i++) {

                        int start = i;
                        int end = i + len - 1;
                        int sum;

                        if (start == end) {
                            sum = nums[i];
                        } else {
                            sum = cache[start][end - 1] + nums[end];
                        }

                        cache[start][end] = sum;

                        if (sum % k == 0) {
                            counter++;
                        }
                    }
                }
                return counter;
            }
        }

    }

}
