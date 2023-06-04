package com.java;

public class Main {
    public static int numberOfCompleteRows(int n) {
        int k = 1;
        while ((k * (k + 1)) / 2 <= n) {
            k++;
        }
        return k - 1;
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        int completeRows = numberOfCompleteRows(n);
        System.out.println("Number of complete rows: " + completeRows);
    }
}
