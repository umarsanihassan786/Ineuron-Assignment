package com.java;

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
    public TreeNode constructBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return constructBSTUtil(arr, 0, arr.length - 1);
    }

    private TreeNode constructBSTUtil(int[] arr, int start, int end) {
        // Base case: If start index exceeds end index
        if (start > end) {
            return null;
        }

        // Create the root node with the value at the start index
        TreeNode root = new TreeNode(arr[start]);

        // Find the index of the first element greater than the root value
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] > root.val) {
                break;
            }
        }

        // Recursively construct the left and right subtrees
        root.left = constructBSTUtil(arr, start + 1, i - 1);
        root.right = constructBSTUtil(arr, i, end);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        Main bstConstructor = new Main();
        TreeNode root = bstConstructor.constructBST(arr);

        // Print the BST using an inorder traversal
        System.out.println("Inorder Traversal:");
        printInorder(root);
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
