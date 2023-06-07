package com.java;

import java.util.Arrays;

public class Main {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize the closest sum to the first three numbers

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    return currentSum; // Exact sum found, return it
                }

                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++; // Move the left pointer towards the right to increase the sum
                } else {
                    right--; // Move the right pointer towards the left to decrease the sum
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));  // Output: 2
    }
}
