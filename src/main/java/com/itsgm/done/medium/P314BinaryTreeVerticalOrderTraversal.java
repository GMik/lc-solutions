package com.itsgm.done.medium;

import java.util.*;

public class P314BinaryTreeVerticalOrderTraversal {

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


    class Solution {

        public List<List<Integer>> verticalOrder(TreeNode root) {

            if (root == null) {
                return new LinkedList<>();
            }

            int[] boundaries = new int[2];
            findBoundaries(root, 0, 0, boundaries);

            int min = boundaries[0];
            int max = boundaries[1];
            int size = max - min + 1;

            List<List<Integer>> res = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                res.add(new LinkedList<>());
            }

            collect(root, min, res);
            return res;
        }


        private void findBoundaries(TreeNode node, int l, int r, int[] res) {

            if (node == null) {
                return;
            }

            int diff = l + r;
            if (node.left == null) {
                findBoundaries(node.right, l, r + 1, res);
            } else if (node.right == null) {
                findBoundaries(node.left, l - 1, r, res);
            } else {
                findBoundaries(node.left, l - 1, r, res);
                findBoundaries(node.right, l, r + 1, res);
            }
            res[0] = Math.min(res[0], diff);
            res[1] = Math.max(res[1], diff);
        }

        private void collect(TreeNode root, int min, List<List<Integer>> res) {

            Queue<Map.Entry<TreeNode, int[]>> queue = new LinkedList<>();
            queue.add(Map.entry(root, new int[2]));

            while (!queue.isEmpty()) {
                Map.Entry<TreeNode, int[]> tempNode = queue.poll();
                res.get(tempNode.getValue()[1] - tempNode.getValue()[0] - min).add(tempNode.getKey().val);

                if (tempNode.getKey().left != null)
                    queue.add(Map.entry(tempNode.getKey().left, new int[]{tempNode.getValue()[0] + 1, tempNode.getValue()[1]}));


                if (tempNode.getKey().right != null)
                    queue.add(Map.entry(tempNode.getKey().right, new int[]{tempNode.getValue()[0], tempNode.getValue()[1] + 1}));

            }
        }


    }
}
