package com.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int firstNonRepeatingCharacter(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Populate the HashMap with character counts
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No non-repeating character found
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstNonRepeatingCharacter(s);
        System.out.println("First non-repeating character index: " + index);
    }
}
