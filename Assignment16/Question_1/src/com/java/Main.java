package com.java;

import java.util.*;

public class Main {
    public static int[] findNearestGreaterFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && frequencyMap.get(arr[i]) >= frequencyMap.get(stack.peek())) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        int[] result = findNearestGreaterFrequency(arr);

        System.out.println(Arrays.toString(result));
    }
}
