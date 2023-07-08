package com.java;

import java.util.Arrays;

public class Main {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize;
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], num);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], num);
        }

        int maxDiff = 0;
        int prevMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            if (minBucket[i] != Integer.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, minBucket[i] - prevMax);
                prevMax = maxBucket[i];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Main msd = new Main();

        int[] nums = {3, 6, 9, 1};
        int maxDiff = msd.maximumGap(nums);
        System.out.println("Maximum Successive Difference: " + maxDiff);
    }
}
