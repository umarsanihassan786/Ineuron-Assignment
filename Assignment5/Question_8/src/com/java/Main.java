package com.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // Invalid input, return empty array
        }

        int[] original = new int[changed.length / 2];
        Map<Integer, Integer> frequency = new HashMap<>();

        // Count the frequency of each element in the changed array
        for (int num : changed) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Reconstruct the original array
        int index = 0;
        for (int num : changed) {
            if (frequency.containsKey(num) && frequency.containsKey(num * 2)) {
                original[index] = num;
                frequency.put(num, frequency.get(num) - 1);
                frequency.put(num * 2, frequency.get(num * 2) - 1);

                if (frequency.get(num) == 0) {
                    frequency.remove(num);
                }
                if (frequency.get(num * 2) == 0) {
                    frequency.remove(num * 2);
                }

                index++;
            }
        }

        if (index != original.length) {
            return new int[0]; // Invalid input, return empty array
        }

        return original;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8}; // Example input

        int[] original = findOriginalArray(changed);

        System.out.println("Original array: " + Arrays.toString(original));
    }
}
