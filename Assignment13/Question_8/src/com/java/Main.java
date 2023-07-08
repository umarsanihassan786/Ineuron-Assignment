package com.java;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Method to insert a node at the beginning of the list
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to delete a node at a given position in the list
    void deleteNode(int position) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node currentNode = head;

        // Case 1: If the node to be deleted is the head node
        if (position == 1) {
            head = currentNode.next;
            if (head != null) {
                head.prev = null;
            }
            currentNode.next = null;
            return;
        }

        // Traverse to the node at the given position
        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        // Case 2: If the node to be deleted is the last node
        if (currentNode.next == null) {
            currentNode.prev.next = null;
            currentNode.prev = null;
            return;
        }

        // Case 3: If the node to be deleted is in between
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        currentNode.prev = null;
        currentNode.next = null;
    }

    // Method to display the doubly linked list
    void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node currentNode = head;
        System.out.print("Doubly Linked List: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);

        System.out.println("Before deletion:");
        dll.display();

        int position = 2;
        dll.deleteNode(position);

        System.out.println("After deletion of node at position " + position + ":");
        dll.display();
    }
}
