package com.itsgm.inprogress;

import java.util.ArrayList;
import java.util.List;

public class P1178NumberOfValidWordsForEachPuzzle {

    static class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

            // 1. avoid check for puzzles starting with same letter, having same set of characters, but in different order
            // 2. when checking a particular word, return TRUE if all characters from specific puzzle where used

            // 10000 words, each 4-50 letters
            // 1000 puzzle sets, each 7 letters

            List<Integer> result = new ArrayList<>();

            int[][] puzzleLetters = new int[puzzles.length][];

            for (int i = 0; i < puzzles.length; i++) {
                puzzleLetters[i] = getPuzzleLetters(puzzles[i]);
            }

            for (int i = 0; i < puzzleLetters.length; i++) {
                int ct = 0;

                for (int j = 0; j < words.length; j++) {
                    if (matchesConditions(words[j], puzzleLetters[i])) {
                        ct++;
                    }

                }

                result.add(ct);
            }
            return result;
        }

        private boolean matchesConditions(String word, int[] puzzleLetters) {

            boolean containsFirstPuzzleLetter = false;

            int ct = 0;
            for (int k = 1; k < word.length(); k++) {

                if (puzzleLetters[word.charAt(k) - 'a' + 1] == 0) {
                    return false;
                }

                if(puzzleLetters[word.charAt(k) - 'a' + 1] == 2){
                    containsFirstPuzzleLetter = true;
                }

                ct++;
                if (ct == puzzleLetters[0] && containsFirstPuzzleLetter) {
                    return true;
                }
            }

            return containsFirstPuzzleLetter;
        }


        //index 0 -> count of distinct letters
        //other indexes: 0, if letter not used in puzzle, 1 if used and non-first letter, 2 if first letter
        private int[] getPuzzleLetters(String puzzle) {
            int[] result = new int['z' - 'a' + 2];
            for (int i = 0; i < puzzle.length(); i++) {
                result[puzzle.charAt(i) - 'a' + 1] = 1;
            }

            int distinctLetters = 0;
            for (int i = 1; i < ('z' - 'a' + 2); i++) {
                distinctLetters += result[i];
            }

            result[0] = distinctLetters;
            result[puzzle.charAt(0) - 'a' + 1] = 2;
            return result;
        }
    }

}
