package com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Main m  = new Main();
		LinkedList list = m.new LinkedList();

		// Create the linked list with the number 123
		list.head = m.new Node(1);
		list.head.next = m.new Node(2);
		list.head.next.next = m.new Node(3);

		list.head = list.addOne(list.head);

		// Display the updated linked list
		Node curr = list.head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		// Output: 1 2 4 (123 + 1 = 124)
	}
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

		public Node addOne(Node head) {
			// Reverse the linked list
			head = reverseLinkedList(head);

			Node curr = head;
			int carry = 1; // Initialize carry to 1 since we want to add 1

			// Traverse the reversed linked list
			while (curr != null && carry > 0) {
				int sum = curr.data + carry;
				curr.data = sum % 10; // Update the current node's value
				carry = sum / 10; // Update the carry

				curr = curr.next; // Move to the next node
			}

			// Reverse the linked list again
			head = reverseLinkedList(head);

			// If there is still a carry, create a new node and update the head
			if (carry > 0) {
				Node newNode = new Node(carry);
				newNode.next = head;
				head = newNode;
			}

			return head;
		}

		private Node reverseLinkedList(Node head) {
			Node prev = null;
			Node curr = head;
			Node next;

			while (curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}

			return prev;
		}

		// Other methods for constructing and displaying the linked list
		// ...
	}


}
