package com.itsgm.inprogress.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P126WordLadderII_bfs {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");

        Solution solution = new Solution();
        List<List<String>> ladders = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);

    }

    static class Solution {

        String endWord;
        List<String> wordList;
        byte[] wordIndices;

        byte[][] cache;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return null;
        }

        public void bfs(Queue<LinkedList<Byte>> queue) {

            LinkedList<Byte> positions;
            int maxLength = Integer.MAX_VALUE;
            boolean hasLengthLowerOrEqualToMaximal = true;

            while (!queue.isEmpty()) {

                positions = queue.remove();

                if (difference(endWord, wordList.get(positions.getLast())) == 1) {

                }


//                for (int i = 0; i < wordList.size(); i++) {
//                    if (!positions.contains(i)) {
//                        queue.add(copyWithElement(positions, i));
//                    }
//                }


            }

        }

        LinkedList<Byte> copyWithElement(LinkedList<Byte> elements, Byte additionalElement) {
            LinkedList<Byte> copy = new LinkedList<>(elements);
            copy.add(additionalElement);
            return copy;
        }


        public int difference(String s1, String s2) {
            int diffCounter = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCounter++;
                }
                if (diffCounter >= 2) {
                    return -1;
                }
            }
            return diffCounter;
        }
    }


}
