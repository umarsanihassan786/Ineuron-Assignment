package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return; // Empty or single-node list, no loop to remove
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the meeting point of the slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // Meeting point found, there is a loop
            }
        }

        if (slow != fast) {
            return; // No loop present, return from the function
        }

        // Move slow pointer to the head and find the start of the loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the loop by breaking the link
        fast.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create a loop by connecting the last node to the second node
        head.next.next.next.next.next = head.next.next;

        Main solution = new Main();
        solution.removeLoop(head);

        // Verify if the loop has been removed
        System.out.println("Linked list after removing the loop:");
        printLinkedList(head);
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
