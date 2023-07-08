package com.java;

public class Main {
    public static int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;
        int totalSum = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);
            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);
            totalSum += num;
        }

        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum circular subarray sum: " + maxSum);
    }
}
