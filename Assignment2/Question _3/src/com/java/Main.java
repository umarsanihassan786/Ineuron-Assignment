package com.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : countMap.keySet()) {
            if (countMap.containsKey(num + 1)) {
                int length = countMap.get(num) + countMap.get(num + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        Main solution = new Main();
        int longestSubsequence = solution.findLHS(nums);
        System.out.println(longestSubsequence);  // Output: 5
    }
}
