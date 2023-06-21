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
    
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            // Return null if the list is empty or has only one node
            return null;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        
        // Move the fast pointer two nodes ahead and the slow pointer one node ahead
        // When the fast pointer reaches the end, the slow pointer will be at the middle (or second middle for even-sized lists)
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }
        
        // Adjust the pointers to delete the middle node(s)
        prev.next = slowPtr.next;
        
        return head;
    }
    
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Main deletion = new Main();
        
        // Example 1: 1->2->3->4->5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        
        System.out.print("Original List 1: ");
        deletion.printList(head1);
        ListNode result1 = deletion.deleteMiddle(head1);
        System.out.print("Modified List 1: ");
        deletion.printList(result1);
        
        // Example 2: 1->2->3->4->5->6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        
        System.out.print("Original List 2: ");
        deletion.printList(head2);
        ListNode result2 = deletion.deleteMiddle(head2);
        System.out.print("Modified List 2: ");
        deletion.printList(result2);
    }
}
