package com.itsgm.done.medium;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/
public class P1650LowestCommonAncestorOfABinaryTreeIII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    // 1. Find level of p
    // 2. Find level of q
    // 3. Loop node -> node.parent until both are on same level
    // 4. Loop node -> node.parent until both share equal reference <- result

    class Solution {
        public Node lowestCommonAncestor(Node p, Node q) {

            int pHeight = 0;
            Node tmp = p;
            while (tmp.parent != null) {
                tmp = tmp.parent;
                pHeight++;
            }

            int qHeight = 0;
            tmp = q;
            while (tmp.parent != null) {
                tmp = tmp.parent;
                qHeight++;
            }

            if (pHeight > qHeight) {
                int diff = pHeight - qHeight;
                while (diff > 0) {
                    p = p.parent;
                    diff--;
                }

            } else if (qHeight > pHeight) {
                int diff = qHeight - pHeight;
                while (diff > 0) {
                    q = q.parent;
                    diff--;
                }
            }

            while (p != q) {
                p = p.parent;
                q = q.parent;
            }

            return p;

        }
    }
}
