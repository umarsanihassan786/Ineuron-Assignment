package com.java;

import java.util.Arrays;

public class Main {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Case 1: Product of the three largest numbers
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        // Case 2: Product of the two smallest negative numbers (if present) and the largest positive number
        int product2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 3, 5};
        Main solution = new Main();
        int maxProduct = solution.maximumProduct(nums);
        System.out.println(maxProduct);  // Output: 60
    }
}
