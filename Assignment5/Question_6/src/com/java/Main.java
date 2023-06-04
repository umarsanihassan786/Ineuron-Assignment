package com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;

            if (nums[index] < 0) {
                duplicates.add(num);
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Example input

        List<Integer> duplicates = findDuplicates(nums);

        System.out.println("Duplicate integers: " + duplicates);
    }
}
