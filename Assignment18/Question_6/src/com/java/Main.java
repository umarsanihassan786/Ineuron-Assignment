package com.java;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int end = points[0][1];
        int arrows = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        Main solution = new Main();
        int minArrows = solution.findMinArrowShots(points);

        System.out.println("Minimum number of arrows required: " + minArrows);
    }
}
