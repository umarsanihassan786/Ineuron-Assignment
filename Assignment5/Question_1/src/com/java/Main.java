package com.java;

public class Main {
    public static int[][] convertTo2D(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        
        if (original.length != m * n) {
            return new int[0][0]; // Return empty array if it's impossible
        }
        
        for (int i = 0; i < original.length; i++) {
            int row = i / n; // Calculate the row index
            int col = i % n; // Calculate the column index
            result[row][col] = original[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6}; // Example input
        int m = 2;
        int n = 3;
        
        int[][] result = convertTo2D(original, m, n);
        
        // Print the resulting 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
