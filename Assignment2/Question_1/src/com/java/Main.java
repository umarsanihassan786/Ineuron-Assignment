package com.java;

import java.util.Arrays;

public class Main {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array in ascending order
        int totalSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            totalSum += nums[i];  // Add the minimum value of each pair to the sum
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        Main solution = new Main();
        int maximizedSum = solution.arrayPairSum(nums);
        System.out.println(maximizedSum);  // Output: 4
    }
}
