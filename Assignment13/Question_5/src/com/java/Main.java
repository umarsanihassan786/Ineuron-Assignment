package com.java;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void deleteLastOccurrence(int key) {
        if (head == null)
            return;

        Node lastOccurrence = null;
        Node prevLastOccurrence = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == key) {
                lastOccurrence = current;
                prevLastOccurrence = prev;
            }

            prev = current;
            current = current.next;
        }

        if (lastOccurrence == null)
            return; // Key not found, no changes needed

        if (prevLastOccurrence == null)
            head = head.next; // Last occurrence is the head, update head
        else
            prevLastOccurrence.next = lastOccurrence.next; // Remove last occurrence
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Create a linked list: 1 -> 2 -> 3 -> 2 -> 4 -> 2
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(4);
        list.head.next.next.next.next.next = new Node(2);

        int key = 2;
        list.deleteLastOccurrence(key);

        // The updated linked list will be: 1 -> 2 -> 3 -> 2 -> 4
        list.display();
    }
}
