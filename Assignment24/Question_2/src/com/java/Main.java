package com.java;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;

        Set<Character> uniqueChars = new HashSet<>();

        while (end < n) {
            char currentChar = s.charAt(end);

            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Main lswrc = new Main();

        String s = "abcabcbb";
        int longestLength = lswrc.lengthOfLongestSubstring(s);
        System.out.println("Length of the Longest Substring Without Repeating Characters: " + longestLength);
    }
}
