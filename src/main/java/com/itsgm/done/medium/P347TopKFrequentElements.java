package com.itsgm.done.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class P347TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            int[] counters = new int[20001];

            for (int i = 0; i < nums.length; i++)
                counters[nums[i] + 10000]++;


            PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, (o1, o2) -> o2.getValue() - o1.getValue());

            for (int i = 0; i < counters.length; i++) {
                if (counters[i] > 0)
                    q.add(Map.entry(i - 10000, counters[i]));

            }

            int[] res = new int[k];

            for (int i = 0; i < k; i++)
                res[i] = q.poll().getKey();


            return res;
        }
    }
}