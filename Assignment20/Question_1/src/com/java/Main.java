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
    private int maxSum;

    public int findMaxSubtreeSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findSubtreeSum(root);
        return maxSum;
    }

    private int findSubtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate the sum of left and right subtrees recursively
        int leftSum = findSubtreeSum(node.left);
        int rightSum = findSubtreeSum(node.right);

        // Calculate the sum of the subtree rooted at the current node
        int currentSum = node.val + leftSum + rightSum;

        // Update the maximum sum if necessary
        maxSum = Math.max(maxSum, currentSum);

        // Return the sum of the subtree rooted at the current node
        return currentSum;
    }

    public static void main(String[] args) {
        // Construct the binary tree for Input1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        // Calculate the maximum subtree sum
        Main subtreeSum = new Main();
        int maxSum1 = subtreeSum.findMaxSubtreeSum(root1);
        System.out.println("Maximum Subtree Sum (Input1): " + maxSum1);

        // Construct the binary tree for Input2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(-2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(-6);
        root2.right.right = new TreeNode(2);

        // Calculate the maximum subtree sum
        int maxSum2 = subtreeSum.findMaxSubtreeSum(root2);
        System.out.println("Maximum Subtree Sum (Input2): " + maxSum2);
    }
}
