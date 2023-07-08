package com.java;

import java.util.*;

public class Main {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a frequency map for elements in nums1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersectionList = new ArrayList<>();

        // Check for common elements and their counts in nums2
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                intersectionList.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        // Convert the list to an array
        int[] intersection = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            intersection[i] = intersectionList.get(i);
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3};

        Main intersectionFinder = new Main();
        int[] intersection = intersectionFinder.intersect(nums1, nums2);

        // Print the intersection array
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}
