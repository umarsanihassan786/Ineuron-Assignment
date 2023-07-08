package com.java;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class Main {
    public void printRightView(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> rightView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if (level == rightView.size()) {
                // The rightmost node at the current level
                rightView.add(node.val);
            } else {
                // Update the rightmost node at the current level
                rightView.set(level, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        // Print the right view nodes
        for (int val : rightView) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Main rightView = new Main();
        rightView.printRightView(root);
    }
}
