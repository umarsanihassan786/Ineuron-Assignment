package com.java;

import java.util.Stack;

public class Main {
    public static void deleteMiddle(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int middleIndex = stack.size() / 2 + 1;
        deleteMiddleUtil(stack, middleIndex, 1);
    }

    private static void deleteMiddleUtil(Stack<Integer> stack, int middleIndex, int currentIndex) {
        if (currentIndex == middleIndex) {
            stack.pop();
            return;
        }

        int element = stack.pop();
        deleteMiddleUtil(stack, middleIndex, currentIndex + 1);
        stack.push(element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        deleteMiddle(stack);
        System.out.println("Stack after deleting middle element: " + stack);
    }
}
