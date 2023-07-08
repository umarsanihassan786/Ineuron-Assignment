package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode deleteNodes(ListNode head, int M, int N) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        ListNode prev = dummy;

        while (current != null) {
            int countM = M;
            int countN = N;

            // Move current M steps forward
            while (countM > 0 && current != null) {
                current = current.next;
                countM--;
            }

            // Move prev N steps forward to skip the next N nodes
            while (countN > 0 && prev.next != null) {
                prev.next = prev.next.next;
                countN--;
            }
        }

        return dummy.next;
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

        int M = 2;
        int N = 2;

        Main solution = new Main();
        ListNode result = solution.deleteNodes(head, M, N);

        // Print the resulting linked list
        System.out.println("Linked list after retaining M=" + M + " nodes and deleting N=" + N + " nodes:");
        printLinkedList(result);
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
