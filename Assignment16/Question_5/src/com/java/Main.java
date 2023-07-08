package com.java;

import java.util.Stack;

public class Main {
    public static int reverseNumber(int number) {
        String numberStr = String.valueOf(number);
        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (char c : numberStr.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();

        // Pop characters from the stack and append them to the new string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Parse the new string back to an integer
        return Integer.parseInt(reversed.toString());
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversedNumber = reverseNumber(number);
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reversedNumber);
    }
}
