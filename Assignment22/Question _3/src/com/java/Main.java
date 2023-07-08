package com.java;

import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class Main {
    public void printRootToLeafPaths(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        stack.push(root);
        pathStack.push("");

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            String currentPath = pathStack.pop() + current.data;

            if (current.left == null && current.right == null) {
                System.out.println(currentPath);
            }

            if (current.right != null) {
                stack.push(current.right);
                pathStack.push(currentPath + "->");
            }

            if (current.left != null) {
                stack.push(current.left);
                pathStack.push(currentPath + "->");
            }
        }
    }

    public static void main(String[] args) {
        Main treePaths = new Main();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Print all root-to-leaf paths
        System.out.println("Root-to-leaf Paths:");
        treePaths.printRootToLeafPaths(root);
    }
}
