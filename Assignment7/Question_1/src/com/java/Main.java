package com.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Boolean> mapped = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (charMap.containsKey(c1)) {
                if (charMap.get(c1) != c2) {
                    return false;
                }
            } else {
                if (mapped.containsKey(c2)) {
                    return false;
                }
                charMap.put(c1, c2);
                mapped.put(c2, true);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));  // Output: true

        s = "foo";
        t = "bar";
        System.out.println(isIsomorphic(s, t));  // Output: false

        s = "paper";
        t = "title";
        System.out.println(isIsomorphic(s, t));  // Output: true
    }
}
