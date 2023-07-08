package com.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value of k.");
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        // Dequeue and push the first k elements onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the remaining elements into the temporary queue
        while (!queue.isEmpty()) {
            tempQueue.add(queue.poll());
        }

        // Enqueue the elements from the stack back into the original queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Enqueue the elements from the temporary queue back into the original queue
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        int k = 3;

        System.out.println("Original Queue: " + queue);
        reverseKElements(queue, k);
        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}
