package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        if (nums.length < 4) {
            return quadruplets; // Return empty list if there are less than four elements in the array
        }

        Arrays.sort(nums); // Sort the array in ascending order

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements to avoid duplicate quadruplets
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicate elements to avoid duplicate quadruplets
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate elements to avoid duplicate quadruplets
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Move the left pointer towards the right
                    } else {
                        right--; // Move the right pointer towards the left
                    }
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> quadruplets = fourSum(nums, target);

        for (List<Integer> quadruplet : quadruplets) {
            System.out.println(quadruplet);
        }
        // Output: [-2, -1, 1, 2]
        //         [-2, 0, 0, 2]
        //         [-1, 0, 0, 1]
    }
}
