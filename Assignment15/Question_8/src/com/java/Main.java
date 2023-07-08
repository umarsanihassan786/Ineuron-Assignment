package com.java;

public class Main {
    public static int trapWater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trapWater(elevationMap);
        System.out.println("Amount of water trapped: " + trappedWater);
    }
}
