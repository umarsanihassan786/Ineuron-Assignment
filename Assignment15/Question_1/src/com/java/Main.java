package com.java;

import java.util.*;

public class Main {
    public static int[] findNextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Iterate over the array in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from the stack until a greater element is found or the stack becomes empty
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // Assign the next greater element to the current element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1; // No greater element found
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 2, 8, 1, 9 };
        int[] nextGreater = findNextGreater(arr);

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println(arr[i] + " --> " + nextGreater[i]);
        }
    }
}
