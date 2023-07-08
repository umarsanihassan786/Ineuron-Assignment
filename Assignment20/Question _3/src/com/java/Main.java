package com.java;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public boolean isValidLevelOrder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the minimum and maximum allowed values
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        // Process the elements of the array
        for (int i = 0; i < n; i++) {
            int current = arr[i];

            // Check if the current element is within the allowed range
            if (current < min || current > max) {
                return false;
            }

            // Update the minimum or maximum allowed values for the next level
            if (!queue.isEmpty() && current < queue.peek()) {
                max = queue.peek();
            } else {
                min = queue.poll();
            }

            // Add the current element to the queue for the next level
            queue.offer(current);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        Main bstCheck = new Main();
        boolean isValid = bstCheck.isValidLevelOrder(arr);

        System.out.println("Is Valid Level Order: " + isValid);
    }
}
