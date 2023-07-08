package com.java;

import java.util.Stack;

public class Main {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < max) {
                return true; // Found a valid 132 pattern
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    max = stack.pop();
                }
                stack.push(nums[i]);
            }
        }

        return false; // No valid 132 pattern found
    }
}
