package com.java;

import java.util.*;

public class Main {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        // Add unique elements from nums1 to the set
        for (int num : nums1) {
            set.add(num);
        }

        // Check for common elements in nums2
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Convert the set to an array
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3};

        Main intersectionFinder = new Main();
        int[] intersection = intersectionFinder.intersection(nums1, nums2);

        // Print the intersection array
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}
