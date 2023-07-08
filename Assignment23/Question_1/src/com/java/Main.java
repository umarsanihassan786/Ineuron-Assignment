package com.java;

import java.util.Stack;

public class Main {
    public static int calculateDepth(String preorder) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;

        for (char ch : preorder.toCharArray()) {
            if (ch == 'n') {
                stack.push(ch);
            } else if (ch == 'l') {
                while (!stack.isEmpty() && stack.peek() == 'l') {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                    stack.push('l');
                    depth = Math.max(depth, stack.size());
                } else {
                    return -1; // Invalid preorder traversal
                }
            }
        }

        if (stack.isEmpty()) {
            return depth;
        } else {
            return -1; // Invalid preorder traversal
        }
    }

    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = calculateDepth(preorder);
        System.out.println("Depth of the binary tree: " + depth);
    }
}
