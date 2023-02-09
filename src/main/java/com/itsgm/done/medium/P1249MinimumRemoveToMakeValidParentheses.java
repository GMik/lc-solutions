package com.itsgm.done.medium;

import java.util.Map;
import java.util.Stack;

public class P1249MinimumRemoveToMakeValidParentheses {

    class Solution {
        public String minRemoveToMakeValid(String s) {

            Stack<Map.Entry<Character, Integer>> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(Map.entry(c, i));
                } else if (c == ')') {
                    if (stack.peek().getKey() == '(') {
                        stack.pop();
                    } else {
                        stack.push(Map.entry(c, i));
                    }
                }
            }

            if (stack.isEmpty()) {
                return s;
            }

            char[] resultChars = new char[s.length() - stack.size()];
            Integer nextIndexToRemove = stack.pop().getValue();

            int currentIndexFromBack = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (nextIndexToRemove == null) {
                    resultChars[(resultChars.length - 1) - currentIndexFromBack++] = s.charAt(i);
                } else if (nextIndexToRemove != i) {
                    resultChars[(resultChars.length - 1) - currentIndexFromBack++] = s.charAt(i);
                } else {
                    nextIndexToRemove = stack.pop().getValue();
                }
            }

            return new String(resultChars);

        }
    }
}
