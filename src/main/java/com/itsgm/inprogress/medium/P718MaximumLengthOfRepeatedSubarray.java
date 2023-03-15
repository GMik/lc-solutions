package com.itsgm.inprogress.medium;


public class P718MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};

        int res = solution.findLength(nums1, nums2);
        System.out.println(res);
    }

    static class Solution {

        // using dynamic programming - classic problem/solution
        public int findLength(int[] nums1, int[] nums2) {

            int len1 = nums1.length;
            int len2 = nums2.length;

            int[][] cache = new int[len1 + 1][len2 + 1];

            int res = 0;

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        cache[i][j] = cache[i - 1][j - 1] + 1;
                        res = Math.max(res, cache[i][j]);
                    }
                }
            }

            return res;

        }

        // brute force with small improvements
        public int findLength2(int[] nums1, int[] nums2) {

            int[] sizes = new int[100];
            int[][] occurrences = new int[100][1000];
            for (int i = 0; i < nums2.length; i++) {
                occurrences[nums2[i]][sizes[nums2[i]]++] = i;
            }

            int result = 0;
            int[] visited = new int[100];

            int length = nums1.length;

            for (int i = 0; i < length; i++) {

                if (result >= length - i) {
                    return result;
                }

                if (visited[nums1[i]] > 0)
                    continue;

                visited[nums1[i]]++;

                for (int j = 0; j < sizes[nums1[i]]; j++) {

                    int localSubarrayLength = 0;

                    int k1 = i;
                    int k2 = occurrences[nums1[i]][j];
                    while (k1 < length && k2 < nums2.length && nums1[k1++] == nums2[k2++]) {
                        localSubarrayLength++;
                    }

                    result = Math.max(result, localSubarrayLength);
                }

            }

            return result;

        }
    }
}
