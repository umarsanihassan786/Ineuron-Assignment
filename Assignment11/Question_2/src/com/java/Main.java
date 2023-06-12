package com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
	    public int findPeakElement(int[] nums) {
	        int left = 0;
	        int right = nums.length - 1;

	        while (left < right) {
	            int mid = left + (right - left) / 2;

	            if (nums[mid] > nums[mid + 1]) {
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        }

	        return left;
	    }


    public static void main(String[] args) {
        int[] n = {1,2,3,4,56,4,5,6,9};

        Main solution = new Main();
        int result = solution.findPeakElement(n);

        System.out.println("Last remaining number: " + result);
    }
}
