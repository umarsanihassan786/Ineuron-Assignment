package com.java;

public class Main {
    public void pushZeros(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == 0) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};

        Main solution = new Main();
        solution.pushZeros(nums);

        System.out.println("Array after pushing zeros to the end:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
