package com.java;

public class Main {
    public static int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;

        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }

        return minX * minY;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};

        int maxIntegers = maxCount(m, n, ops);
        System.out.println(maxIntegers);
    }
}
