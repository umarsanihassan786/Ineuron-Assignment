package com.java;

import java.util.Stack;

public class Main {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Main() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        int poppedElement = stack.pop();

        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        Main minStack = new Main();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);

        System.out.println(minStack.getMin()); // Output: 1

        minStack.pop();
        System.out.println(minStack.top()); // Output: 2

        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 3
    }
}
