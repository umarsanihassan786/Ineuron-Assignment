package com.java;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            current.prev = nextNode;
            previous = current;
            current = nextNode;
        }

        head.prev = null;
        return previous;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Create a sample doubly linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        // Print the original list
        System.out.println("Original List:");
        dll.printList(head);

        // Reverse the list
        Node reversedHead = dll.reverse(head);

        // Print the reversed list
        System.out.println("\nReversed List:");
        dll.printList(reversedHead);
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
