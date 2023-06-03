package com.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static List<List<Integer>> findDisjointElements(int[] nums1, int[] nums2) {
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> setNums2 = new HashSet<>();
        
        for (int num : nums1) {
            setNums1.add(num);
        }
        
        for (int num : nums2) {
            setNums2.add(num);
        }
        
        List<Integer> distinctNums1 = new ArrayList<>();
        List<Integer> distinctNums2 = new ArrayList<>();
        
        for (int num : setNums1) {
            if (!setNums2.contains(num)) {
                distinctNums1.add(num);
            }
        }
        
        for (int num : setNums2) {
            if (!setNums1.contains(num)) {
                distinctNums2.add(num);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(distinctNums1);
        result.add(distinctNums2);
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = findDisjointElements(nums1, nums2);
        System.out.println(result);
    }
}
