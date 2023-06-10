package com.java;

public class Main {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        
        double logValue = Math.log10(n) / Math.log10(3);
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    public static void main(String[] args) {
        int n = 27;

        Main solution = new Main();
        boolean result = solution.isPowerOfThree(n);

        System.out.println("Is " + n + " a power of three? " + result);
    }
}
