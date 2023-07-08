package com.java;

import java.util.*;

public class Main {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the starting point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                // No overlap, add the current interval to the result list
                mergedIntervals.add(interval);
            } else {
                // Overlap, update the end point of the last interval in the result list
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(interval[1], mergedIntervals.get(mergedIntervals.size() - 1)[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Main solution = new Main();
        int[][] merged = solution.merge(intervals);

        // Print the merged intervals
        System.out.println("Merged intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
