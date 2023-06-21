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
    
    public ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        if (head1 != null) {
            curr.next = head1;
        }
        if (head2 != null) {
            curr.next = head2;
        }
        
        return dummy.next;
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
        Main merger = new Main();
        
        // Example: Merge two linked lists
        
        // List 1: 1 -> 3 -> 5 -> 7
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        
        // List 2: 2 -> 4 -> 6 -> 8
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        
        System.out.print("List 1: ");
        merger.printList(head1);
        System.out.print("List 2: ");
        merger.printList(head2);
        
        ListNode mergedList = merger.mergeLists(head1, head2);
        
        System.out.print("Merged List: ");
        merger.printList(mergedList);
    }
}
