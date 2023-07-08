package com.java;

import java.util.Stack;

public class Main {
    public static int countWordsLeft(String sequence) {
        String[] words = sequence.split(" ");
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (stack.isEmpty() || !word.equals(stack.peek())) {
                stack.push(word);
            } else {
                stack.pop();
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String sequence = "ab aa aa bcd ab";
        int wordsLeft = countWordsLeft(sequence);
        System.out.println("Number of words left after pairwise destruction: " + wordsLeft);
    }
}
