package com.java;

public class Main {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // If the mid version is bad, search in the left half
                right = mid;
            } else {
                // If the mid version is good, search in the right half
                left = mid + 1;
            }
        }

        return left;
    }

    // Dummy implementation of isBadVersion for testing
    private boolean isBadVersion(int version) {
        // Replace this with your actual implementation of isBadVersion
        // The function should return true if the version is bad, false otherwise
        // The logic will depend on your specific requirements and constraints
        return false;
    }

    public static void main(String[] args) {
        int n = 10;
        Main badVersion = new Main();
        int firstBad = badVersion.firstBadVersion(n);
        System.out.println("First Bad Version: " + firstBad);
    }
}
