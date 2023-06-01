package com.java;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public int maxCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        Set<Integer> uniqueCandyTypes = new HashSet<>();
        for (int candy : candyType) {
            uniqueCandyTypes.add(candy);
        }
        int uniqueCount = uniqueCandyTypes.size();
        return Math.min(uniqueCount, maxCandies);
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        Main solution = new Main();
        int maxTypes = solution.maxCandies(candyType);
        System.out.println(maxTypes);  // Output: 3
    }
}
