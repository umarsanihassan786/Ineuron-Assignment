package com.java;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public int findTheWinner(int n, int k) {
        // Create circular linked list
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= n; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        curr.next = head; // Make it circular

        // Traverse to (k-1)th friend
        curr = head;
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }

        // Play the game until one friend remains
        while (curr.next != curr) {
            // Remove the kth friend
            curr.next = curr.next.next;
            curr = curr.next;

            // Move to the friend immediately clockwise
            for (int i = 0; i < k - 1; i++) {
                curr = curr.next;
            }
        }

        return curr.val; // Return the remaining friend
    }

    public static void main(String[] args) {
        Main gameWinner = new Main();
        int n = 5;
        int k = 2;
        int winner = gameWinner.findTheWinner(n, k);
        System.out.println("The winner of the game is friend " + winner);
    }
}
