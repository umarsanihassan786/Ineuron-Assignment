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
    public int findDistance(TreeNode root, int node1, int node2) {
        TreeNode lcaNode = findLCA(root, node1, node2);
        int distance1 = findDistanceFromNode(lcaNode, node1, 0);
        int distance2 = findDistanceFromNode(lcaNode, node2, 0);
        return distance1 + distance2;
    }

    private TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.val > node1 && root.val > node2) {
            return findLCA(root.left, node1, node2);
        }

        if (root.val < node1 && root.val < node2) {
            return findLCA(root.right, node1, node2);
        }

        return root;
    }

    private int findDistanceFromNode(TreeNode node, int target, int distance) {
        if (node == null) {
            return -1;
        }

        if (node.val == target) {
            return distance;
        }

        if (node.val > target) {
            return findDistanceFromNode(node.left, target, distance + 1);
        }

        return findDistanceFromNode(node.right, target, distance + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        int node1 = 2;
        int node2 = 8;

        Main distanceFinder = new Main();
        int distance = distanceFinder.findDistance(root, node1, node2);

        System.out.println("Distance between " + node1 + " and " + node2 + ": " + distance);
    }
}
