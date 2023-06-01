package com.java;

public class Main {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Main solution = new Main();
        boolean isMonotonic = solution.isMonotonic(nums);
        System.out.println(isMonotonic);  // Output: true
    }
}
