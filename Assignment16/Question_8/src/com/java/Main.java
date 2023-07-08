package com.java;

import java.util.Stack;

public class Main {
    public static int maxDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate nearest smaller element on the left side
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        stack.clear();

        // Calculate nearest smaller element on the right side
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        int maxDiff = Integer.MIN_VALUE;

        // Calculate the maximum absolute difference
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8};
        int maxDiff = maxDifference(arr);
        System.out.println("Maximum absolute difference: " + maxDiff);
    }
}
