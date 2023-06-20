package com.java;

import java.util.*;

public class Main {
    public static int[] findNearestSmaller(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate over the array from left to right
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until a smaller element is found or the stack becomes empty
            while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }

            // Assign the nearest smaller element for the current element
            if (!stack.isEmpty()) {
                result[i] = a[stack.peek()];
            } else {
                result[i] = -1; // No smaller element found
            }

            // Push the current element's index onto the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 10, 8 };
        int[] nearestSmaller = findNearestSmaller(a);

        System.out.println("Nearest Smaller Elements:");
        for (int i = 0; i < nearestSmaller.length; i++) {
            System.out.println(a[i] + " --> " + nearestSmaller[i]);
        }
    }
}
