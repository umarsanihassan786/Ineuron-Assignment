package com.java;

import java.util.*;

public class Main {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search to find the index of the closest element to x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Initialize the left and right pointers for finding the k closest elements
        left = right - 1;
        right = right + 1;

        // Compare the absolute differences between arr[left] and x, and arr[right] and x
        // Move the pointers accordingly until k elements are found
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } else if (right < arr.length) {
                result.add(arr[right]);
                right++;
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> closestElements = findClosestElements(arr, k, x);

        // Print the k closest elements
        System.out.println("K closest elements to " + x + ":");
        for (int num : closestElements) {
            System.out.println(num);
        }
    }
}
