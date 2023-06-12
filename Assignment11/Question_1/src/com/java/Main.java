package com.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
	    public int mySqrt(int x) {
	        if (x == 0)
	            return 0;
	        
	        long left = 1;
	        long right = x;
	        
	        while (left <= right) {
	            long mid = left + (right - left) / 2;
	            long square = mid * mid;
	            
	            if (square == x)
	                return (int) mid;
	            else if (square > x)
	                right = mid - 1;
	            else
	                left = mid + 1;
	        }
	        
	        return (int) right;
	    }


    public static void main(String[] args) {
        int n = 9;

        Main solution = new Main();
        int result = solution.mySqrt(n);

        System.out.println("Last remaining number: " + result);
    }
}
