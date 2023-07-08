package com.java;

public class Main {
    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0) {
            int quotient = num / values[i];

            for (int j = 0; j < quotient; j++) {
                sb.append(symbols[i]);
                num -= values[i];
            }

            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 27;
        String romanNumeral = intToRoman(num);
        System.out.println("Roman numeral representation: " + romanNumeral);
    }
}
