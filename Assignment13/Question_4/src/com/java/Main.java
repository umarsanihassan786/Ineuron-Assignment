package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
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

        // If there are more nodes, recursively reverse the next alternate k nodes
        if (next != null) {
            head.next = next;
            for (int i = 0; i < k - 1 && next != null; i++) {
                next = next.next;
            }
            if (next != null) {
                next.next = reverseAlternateKGroup(next.next, k);
            }
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
        ListNode modifiedList = solution.reverseAlternateKGroup(head, k);

        // Print the modified linked list
        System.out.println("Modified linked list:");
        printLinkedList(modifiedList);
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
