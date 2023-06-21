package com.java;

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {
    
    public boolean hasLoop(ListNode head) {
        if (head == null || head.next == null) {
            // Return false if the list is empty or has only one node
            return false;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if (slowPtr == fastPtr) {
                // Loop detected
                return true;
            }
        }
        
        // No loop found
        return false;
    }
    
    public static void main(String[] args) {
        Main loopDetection = new Main();
        
        // Example 1: No loop
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        
        System.out.println("Has loop in Example 1: " + loopDetection.hasLoop(head1));
        
        // Example 2: Loop present
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = head2.next; // Creating a loop
        
        System.out.println("Has loop in Example 2: " + loopDetection.hasLoop(head2));
    }
}
