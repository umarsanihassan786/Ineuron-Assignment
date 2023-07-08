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

class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    DoublyLinkedListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode convertToDoublyLinkedList(TreeNode root) {
        head = null;
        prev = null;
        convertToDoublyLinkedListUtil(root);
        return head;
    }

    private void convertToDoublyLinkedListUtil(TreeNode node) {
        if (node == null) {
            return;
        }

        // Recursively convert the left subtree
        convertToDoublyLinkedListUtil(node.left);

        // Create a new doubly linked list node with the current node value
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(node.val);

        // Set the prev and next pointers of the new node
        if (prev == null) {
            // First node in the doubly linked list
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
        }

        prev = newNode;

        // Recursively convert the right subtree
        convertToDoublyLinkedListUtil(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Main converter = new Main();
        DoublyLinkedListNode dllHead = converter.convertToDoublyLinkedList(root);

        // Print the doubly linked list in both forward and backward directions
        System.out.println("Doubly Linked List (Forward):");
        printDoublyLinkedListForward(dllHead);

        System.out.println("\nDoubly Linked List (Backward):");
        printDoublyLinkedListBackward(dllHead);
    }

    // Utility method to print the doubly linked list in forward direction
    private static void printDoublyLinkedListForward(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // Utility method to print the doubly linked list in backward direction
    private static void printDoublyLinkedListBackward(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.prev;
        }
    }
}
