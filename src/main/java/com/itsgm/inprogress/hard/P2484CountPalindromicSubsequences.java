package com.itsgm.inprogress.hard;

public class P2484CountPalindromicSubsequences {

    static class Solution {

        int[][][] cache;

        public int countPalindromes(String s) {

            if (s.length() < 5) {
                return 0;
            }

            int result = 0;

            cache = new int[10][10][10];
            int len = s.length();

            for (int i = 0; i < len - 4; i++) {
                for (int j = i+1; j < len - 3; j++) {
                    for (int k = j+1; k < len - 2; k++) {
                        for (int l = k+1; l < len - 1; l++) {
                            for (int m = l+1; m < len; m++) {
                                result += isPalindromic(s, i, j, k, l, m);
                            }
                        }
                    }
                }
            }

            return result;
        }

        public int isPalindromic(String s, int i, int j, int k, int l, int m) {
            return s.charAt(i) == s.charAt(m) && s.charAt(j) == s.charAt(l) ? 1 : 0;
        }


    }
}
