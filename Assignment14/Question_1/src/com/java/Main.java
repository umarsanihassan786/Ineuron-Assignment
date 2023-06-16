package com.java;

import java.util.ArrayList;
import java.util.List;
public class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    
    public void detectAndRemoveLoop() {
        if (head == null || head.next == null) {
            return;
        }
        
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        if (slow != fast) {
            // No loop exists
            return;
        }
        
        // Move slow to the head of the list
        slow = head;
        
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        
        // Remove the loop
        prev.next = null;
    }
    
    // Other methods for constructing and displaying the linked list
    // ...
}

public class Main {
	   

	    public static void main(String[] args) {
	        LinkedList list = new LinkedList();
	        
	        // Create the linked list with a loop
	        list.head = new Node(1);
	        list.head.next = new Node(2);
	        list.head.next.next = new Node(3);
	        list.head.next.next.next = new Node(4);
	        list.head.next.next.next.next = new Node(5);
	        list.head.next.next.next.next.next = new Node(6);
	        list.head.next.next.next.next.next.next = list.head.next.next;  // Loop from node 3 to node 2
	        
	        list.detectAndRemoveLoop();
	    }

}
