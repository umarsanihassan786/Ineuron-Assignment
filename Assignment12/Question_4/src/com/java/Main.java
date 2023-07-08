package com.java;

class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
    }
}

public class Main {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty or single-node list is a palindrome
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find the middle and reverse the first half of the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // Reverse the pointers of the first half
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Handle the case of odd number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the characters of the first half with the reversed second half
        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false; // Characters don't match, not a palindrome
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true; // All characters match, it's a palindrome
    }

    public static void main(String[] args) {
        ListNode head = new ListNode('r');
        head.next = new ListNode('a');
        head.next.next = new ListNode('d');
        head.next.next.next = new ListNode('a');
        head.next.next.next.next = new ListNode('r');

        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
