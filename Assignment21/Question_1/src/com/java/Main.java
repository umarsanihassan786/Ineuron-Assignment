package com.java;

import java.util.ArrayList;
import java.util.List;

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

public class Main {
    private List<Integer> sortedValues;

    public TreeNode convertToBST(TreeNode root) {
        // Step 1: Perform inorder traversal to get sorted values
        sortedValues = new ArrayList<>();
        inorderTraversal(root);

        // Step 2: Construct a new BST using the sorted values
        return constructBST(0, sortedValues.size() - 1);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        sortedValues.add(node.val);
        inorderTraversal(node.right);
    }

    private TreeNode constructBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedValues.get(mid));

        node.left = constructBST(start, mid - 1);
        node.right = constructBST(mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        Main converter = new Main();
        TreeNode bstRoot = converter.convertToBST(root);

        // Print the BST using an inorder traversal
        System.out.println("Inorder Traversal of BST:");
        printInorder(bstRoot);
    }

    // Utility method to print the BST using inorder traversal
    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
