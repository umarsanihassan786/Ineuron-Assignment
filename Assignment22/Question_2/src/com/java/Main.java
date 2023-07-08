package com.java;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class Main {
    public void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode levelStart = root;

        while (levelStart != null) {
            TreeNode current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }

                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Main connector = new Main();
        connector.connect(root);

        // Print the next pointers of each node
        System.out.println("Next Pointers:");
        printNextPointers(root);
    }

    // Utility method to print the next pointers of each node
    private static void printNextPointers(TreeNode root) {
        TreeNode currentLevel = root;

        while (currentLevel != null) {
            TreeNode current = currentLevel;
            while (current != null) {
                System.out.print(current.val + "->");
                current = current.next;
            }

            System.out.println("null");
            currentLevel = currentLevel.left;
        }
    }
}
