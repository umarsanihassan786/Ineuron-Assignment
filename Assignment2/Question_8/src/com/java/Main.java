package com.java;

public class Main {
    public int minimumScore(int[] nums, int k) {
        int n = nums.length;
        int minScore = Integer.MAX_VALUE;

        // Try all possible values for each element in nums
        for (int i = 0; i < n; i++) {
            for (int x = -k; x <= k; x++) {
                int[] modifiedNums = nums.clone();
                modifiedNums[i] += x;
                int score = calculateScore(modifiedNums);
                minScore = Math.min(minScore, score);
            }
        }

        return minScore;
    }

    private int calculateScore(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Calculate the maximum and minimum elements in nums
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max - min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7};
        int k = 3;
        Main solution = new Main();
        int minScore = solution.minimumScore(nums, k);
        System.out.println(minScore);  // Output: 4
    }
}
