package com.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static boolean checkElementsInIncreasingOrder(Queue<Integer> queue) {
        int expectedElement = 1;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> auxQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            if (queue.peek() == expectedElement) {
                auxQueue.add(queue.poll());
                expectedElement++;
            } else if (!stack.isEmpty() && stack.peek() == expectedElement) {
                auxQueue.add(stack.pop());
                expectedElement++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == expectedElement) {
                auxQueue.add(stack.pop());
                expectedElement++;
            } else {
                return false;
            }
        }

        return auxQueue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(1);
        queue.add(5);
        queue.add(3);
        queue.add(4);

        boolean canArrange = checkElementsInIncreasingOrder(queue);
        System.out.println("Can elements be arranged in increasing order? " + canArrange);
    }
}
