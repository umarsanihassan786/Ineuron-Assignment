package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> commonElements = new HashSet<>();
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                commonElements.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                int minVal = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
                if (arr1[p1] == minVal) {
                    p1++;
                }
                if (arr2[p2] == minVal) {
                    p2++;
                }
                if (arr3[p3] == minVal) {
                    p3++;
                }
            }
        }

        return new ArrayList<>(commonElements);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};

        List<Integer> result = findCommonElements(arr1, arr2, arr3);
        System.out.println(result);
    }
}
