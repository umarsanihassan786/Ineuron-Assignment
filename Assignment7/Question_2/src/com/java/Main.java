package com.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> strobogrammaticMap = new HashMap<>();
        strobogrammaticMap.put('0', '0');
        strobogrammaticMap.put('1', '1');
        strobogrammaticMap.put('6', '9');
        strobogrammaticMap.put('8', '8');
        strobogrammaticMap.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);

            if (!strobogrammaticMap.containsKey(c1) || !strobogrammaticMap.containsKey(c2)) {
                return false;
            }

            if (strobogrammaticMap.get(c1) != c2) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String num = "69";
        System.out.println(isStrobogrammatic(num));  // Output: true

        num = "88";
        System.out.println(isStrobogrammatic(num));  // Output: true

        num = "962";
        System.out.println(isStrobogrammatic(num));  // Output: false
    }
}
