package com.java;

import java.util.Stack;

public class Main {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                // Operand: Push onto stack
                stack.push(Character.getNumericValue(c));
            } else {
                // Operator: Pop top two elements and perform the operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = performOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        // The top element of the stack will be the final result
        return stack.pop();
    }

    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "52+3*";
        int result = evaluatePostfix(expression);
        System.out.println("Postfix expression: " + expression);
        System.out.println("Result: " + result);
    }
}
