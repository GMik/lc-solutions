package com.itsgm.done.medium;

import java.util.Map;
import java.util.Stack;

public class P2096StepByStepDirectionsFromABinaryTreeNodeToAnother {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *
     * fast - using string builder as stack/queue, just find both paths like LRRRLRLLR/LRRLRL, remove common prefix, replace with 'U' for start's part
     * private boolean find(TreeNode n, int val, StringBuilder sb) {
     *     if (n.val == val)
     *         return true;
     *     if (n.left != null && find(n.left, val, sb))
     *         sb.append("L");
     *     else if (n.right != null && find(n.right, val, sb))
     *         sb.append("R");
     *     return sb.length() > 0;
     * }
     * public String getDirections(TreeNode root, int startValue, int destValue) {
     *     StringBuilder s = new StringBuilder(), d = new StringBuilder();
     *     find(root, startValue, s);
     *     find(root, destValue, d);
     *     int i = 0, max_i = Math.min(d.length(), s.length());
     *     while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
     *         ++i;
     *     return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
     * }
     */

    class Solution {
        public String getDirections(TreeNode root, int startValue, int destValue) {

            Stack<Map.Entry<TreeNode, Character>> startStack = new Stack<>();
            Stack<Map.Entry<TreeNode, Character>> destStack = new Stack<>();

            fillStack(root, startValue, startStack, 'R');
            fillStack(root, destValue, destStack, 'R');

            int startHeight = startStack.size();
            int destHeight = destStack.size();

            int diff = Math.abs(startHeight - destHeight);

            StringBuilder startPart = new StringBuilder();
            StringBuilder destPart = new StringBuilder();

            if (startHeight > destHeight) {
                while (diff-- > 0) {
                    startStack.pop();
                    startPart.append('U');
                }
            } else if (destHeight > startHeight) {
                while (diff-- > 0) {
                    destPart.append(destStack.pop().getValue());
                }
            }

            Map.Entry<TreeNode, Character> startSideNode = null;
            Map.Entry<TreeNode, Character> destSideNode = null;
            while ((startSideNode = startStack.pop()).getKey() != (destSideNode = destStack.pop()).getKey()) {
                startPart.append('U');
                destPart.append(destSideNode.getValue());
            }

            return startPart.toString() + destPart.reverse();

        }

        char LEFT = 'L';
        char RIGHT = 'R';


        public boolean fillStack(TreeNode current,
                                 int value,
                                 Stack<Map.Entry<TreeNode, Character>> stack,
                                 char dir) {

            if (current == null) {
                return false;
            }

            stack.push(Map.entry(current, dir));

            if (current.val == value) {
                return true;
            } else {
                if (!fillStack(current.left, value, stack, LEFT) && !fillStack(current.right, value, stack, RIGHT)) {
                    stack.pop();
                    return false;
                }
                return true;
            }
        }


//        public void fillStacks(TreeNode current,
//                               int startValue,
//                               int destValue,
//                               Stack<Map.Entry<TreeNode, Character>> startStack,
//                               Stack<Map.Entry<TreeNode, Character>> destStack,
//                               boolean[] found,
//                               char dir) {
//
//            if (current == null) {
//                return;
//            }
//
//            startStack.push(Map.entry(current, dir));
//            destStack.push(Map.entry(current, dir));
//
//            found[0] = found[0] || startValue == current.val;
//            found[1] = found[1] || destValue == current.val;
//
//            if (found[0] && found[1]) {
//                return;
//            } else {
//                fillStacks(current.left, startValue, destValue, startStack, destStack, found, LEFT);
//
//            }
//        }


    }
}
