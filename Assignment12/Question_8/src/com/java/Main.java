package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public boolean isCircular(ListNode head) {
        if (head == null) {
            return false; // Empty list, not circular
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Circular list, fast pointer catches up to slow pointer
            }
        }

        return false; // Not circular, fast pointer reaches the end of the list
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // Make the list circular

        Main solution = new Main();
        boolean isCircular = solution.isCircular(head);
        System.out.println("Is the linked list circular? " + isCircular);
    }
}
