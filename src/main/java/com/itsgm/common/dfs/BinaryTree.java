package com.itsgm.common.dfs;

import java.util.List;
import java.util.Stack;

public class BinaryTree {

    Node root;

    void inorderRecursive(Node node, List<Node> collector) {
        if (node == null) {
            return;
        }

        inorderRecursive(node.left, collector);
        collector.add(node);
        inorderRecursive(node.right, collector);

    }

    void preorderRecursive(Node node, List<Node> collector) {
        if (node == null) {
            return;
        }

        collector.add(node);
        preorderRecursive(node.left, collector);
        preorderRecursive(node.right, collector);

    }

    void postorderRecursive(Node node, List<Node> collector) {
        if (node == null) {
            return;
        }

        postorderRecursive(node.left, collector);
        postorderRecursive(node.right, collector);
        collector.add(node);

    }

    void inorderIterative(Node root, List<Node> collector) {

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            collector.add(curr);

            curr = curr.right;
        }


    }


}
