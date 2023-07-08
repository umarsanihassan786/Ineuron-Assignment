package com.java;

public class Main {
    public void sortColors(int[] nums) {
        int low = 0; // pointer for red objects
        int mid = 0; // pointer for white objects
        int high = nums.length - 1; // pointer for blue objects

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap the current element with the element at the low pointer
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Increment the mid pointer, as white objects should be in the middle
                mid++;
            } else if (nums[mid] == 2) {
                // Swap the current element with the element at the high pointer
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
