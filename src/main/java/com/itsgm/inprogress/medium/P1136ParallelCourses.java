package com.itsgm.inprogress.medium;

import java.util.*;

//https://leetcode.com/problems/parallel-courses/description/
public class P1136ParallelCourses {

    class Solution {

        public int minimumSemesters(int n, int[][] relations) {

            //3: {1,2}
            //1: {}
            //2: {}

            //1: 3
            //2: 3
            //3: /

            // pre-setup:
            Map<Integer, Set<Integer>> incoming = new HashMap<>();
            Map<Integer, Set<Integer>> outgoing = new HashMap<>();

            for (int i = 0; i < relations.length; i++) {

                int start = relations[i][0];
                int end = relations[i][1];

                Set<Integer> incomingSet = incoming.get(end);
                if (incomingSet == null) {
                    incomingSet = new HashSet<>();
                    incomingSet.add(start);
                    incoming.put(end, incomingSet);
                } else {
                    incomingSet.add(start);
                }

                Set<Integer> outgoingSet = outgoing.get(start);
                if (outgoingSet == null) {
                    outgoingSet = new HashSet<>();
                    outgoingSet.add(end);
                    outgoing.put(start, outgoingSet);
                } else {
                    outgoingSet.add(end);
                }
            }

//            Iterator<Map.Entry<Integer, Set<Integer>>> incomingIterator = incoming.entrySet().iterator();
//            int counter = 0;
//            while (incomingIterator.hasNext()) {
//                Map.Entry<Integer, Set<Integer>> entry = incomingIterator.next();
//                if (entry.getValue().size() == 0) {
//                    counter++;
//                    incoming.get(outgoing.get(entry.getKey())).remove()
//                    outgoing.remove(entry.getKey());
//                    incomingIterator.remove();
//                }
//            }

            // there is a cycle
//            if (counter == 0) {
//                return -1;
//            }

            return -1;

        }
    }
}
