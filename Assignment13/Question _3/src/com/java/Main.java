package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;

        // Reverse the first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If there are more than k nodes remaining, recursively reverse the next group
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Connect the reversed group to the previous group or the head of the linked list
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 3;

        Main solution = new Main();
        ListNode reversedList = solution.reverseKGroup(head, k);

        // Print the reversed linked list
        System.out.println("Reversed linked list:");
        printLinkedList(reversedList);
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
