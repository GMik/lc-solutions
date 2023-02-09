package com.itsgm.done.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class P1334FindTheCityWithTheSmallestNumberOfNeighboursAtAThresholdDistance {

    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] distances = new int[n][n];
            int result = 0;
            int smallest = n;

            for (int[] row : distances)
                Arrays.fill(row, 10001);

            for (int[] e : edges)
                distances[e[0]][e[1]] = distances[e[1]][e[0]] = e[2];

            for (int i = 0; i < n; ++i)
                distances[i][i] = 0;

            for (int k = 0; k < n; ++k)
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < n; ++j)
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; ++j)
                    if (distances[i][j] <= distanceThreshold) ++count;
                if (count <= smallest) {
                    result = i;
                    smallest = count;
                }
            }

            return result;
        }
    }
}
