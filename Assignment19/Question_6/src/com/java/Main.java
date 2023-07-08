package com.java;

public class Main {
    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int k = 0; // Pointer for merged array

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy the remaining elements from nums1, if any
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy the remaining elements from nums2, if any
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};

        Main merger = new Main();
        int[] mergedArray = merger.merge(nums1, nums2);

        // Print the merged array
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
