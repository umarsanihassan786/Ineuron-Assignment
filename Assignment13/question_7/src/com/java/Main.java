package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public void insertAlternate(ListNode first, ListNode second) {
        ListNode firstPtr = first;
        ListNode secondPtr = second;

        while (firstPtr != null && secondPtr != null) {
            ListNode tempPtr = firstPtr.next;

            firstPtr.next = secondPtr;
            secondPtr = secondPtr.next;
            firstPtr.next.next = tempPtr;

            firstPtr = firstPtr.next.next;
        }

        second = secondPtr;
        // Set the next pointer of the last node in the first list to null
        if (firstPtr != null) {
            firstPtr.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(5);
        first.next = new ListNode(7);
        first.next.next = new ListNode(17);
        first.next.next.next = new ListNode(13);
        first.next.next.next.next = new ListNode(11);

        ListNode second = new ListNode(12);
        second.next = new ListNode(10);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(4);
        second.next.next.next.next = new ListNode(6);

        Main solution = new Main();
        solution.insertAlternate(first, second);

        // Print the modified first list
        System.out.println("First list after inserting alternate nodes from the second list:");
        printLinkedList(first);

        // Print the modified second list
        System.out.println("Second list after insertion: ");
        printLinkedList(second);
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
