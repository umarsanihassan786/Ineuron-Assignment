package com.java;

import java.util.*;

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class Main {
    public List<int[]> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Pair[] pairs = new Pair[n];
        Integer[] sortedIndices = new Integer[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
            sortedIndices[i] = i;
        }

        mergeSort(pairs, sortedIndices, 0, n - 1, result);

        return Arrays.asList(result);
    }

    private void mergeSort(Pair[] pairs, Integer[] sortedIndices, int left, int right, int[] result) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(pairs, sortedIndices, left, mid, result);
        mergeSort(pairs, sortedIndices, mid + 1, right, result);
        merge(pairs, sortedIndices, left, mid, right, result);
    }

    private void merge(Pair[] pairs, Integer[] sortedIndices, int left, int mid, int right, int[] result) {
        int i = left;
        int j = mid + 1;
        int smallerCount = 0;
        int[] sorted = new int[right - left + 1];
        int index = 0;

        while (i <= mid && j <= right) {
            if (pairs[sortedIndices[i]].value > pairs[sortedIndices[j]].value) {
                smallerCount++;
                sorted[index++] = sortedIndices[j++];
            } else {
                result[sortedIndices[i]] += smallerCount;
                sorted[index++] = sortedIndices[i++];
            }
        }

        while (i <= mid) {
            result[sortedIndices[i]] += smallerCount;
            sorted[index++] = sortedIndices[i++];
        }

        while (j <= right) {
            sorted[index++] = sortedIndices[j++];
        }

        System.arraycopy(sorted, 0, sortedIndices, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};

        Main solution = new Main();
        List<int[]> counts = solution.countSmaller(nums);

        System.out.println("Counts of smaller numbers after self:");
        System.out.println(counts);
    }
}
