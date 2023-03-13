package com.itsgm.done.medium;

public class P835ImageOverlap_slow {

    class Solution {


        public int largestOverlap(int[][] img1, int[][] img2) {

            // length of vertical/horizontal side
            int n = img1.length;

            // count of '1' in second image
            int maxPossibleOverlap = maxOverlap(img2, n);

            if (maxPossibleOverlap == 1 && maxOverlap(img1, n) > 1) {
                return 1;
            }

            // overlap without any shifting of first image - when equal to max possible, return
            int currentMaxOverlap = getOverlap(img1, img2, n);
            if (currentMaxOverlap == maxPossibleOverlap) {
                return currentMaxOverlap;
            }

            // extra allocated space per side (u/d/l/r)
            int k = n - 1;

            // content of first image surrounded by zeros - to avoid shifting them (allocates additionallu ~9*n memory)
            int[][] extendedImg = new int[n + 2 * k][n + 2 * k];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    extendedImg[i + k][j + k] = img1[i][j];
                }
            }

            // works, but slow
            int res = 0;
            for (int i = 0; i < 2 * n - 1; i++) {
                for (int j = 0; j < 2 * n - 1; j++) {
                    res = Math.max(res, getOverlap(extendedImg, img2, n, i, j));
                }
            }

            return res;
        }


        int maxOverlap(int[][] img, int n) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += img[i][j];
                }
            }
            return res;
        }

        int getOverlap(int[][] img1, int[][] img2, int n) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += (img1[i][j] == 1 && img2[i][j] == 1 ? 1 : 0);
                }
            }
            return res;
        }

        int getOverlap(int[][] img1, int[][] img2, int n, int is, int js) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += (img1[i + is][j + js] == 1 && img2[i][j] == 1 ? 1 : 0);
                }
            }
            return res;
        }

    }

    /**
     * i=0
     * i=1
     * i=2
     * i=3
     * i=4
     * i=5
     *
     * n = 6
     *
     * up = 2;
     *
     *  if(n - i <= up)
     *
     */

}
