package com.java;

public class Main {
    private int[] stream;
    private int value;
    private int kValue;
    private int count;
    private int pointer;

    public Main(int value, int k) {
        this.stream = new int[k];
        this.value = value;
        this.kValue = k;
        this.count = 0;
        this.pointer = 0;
        for (int i = 0; i < k; i++) {
            stream[i] = -1;
        }
    }

    public boolean consec(int num) {
        if (count < kValue) {
            stream[pointer] = num;
            count++;
        } else {
            stream[pointer] = num;
        }
        pointer = (pointer + 1) % kValue;

        for (int i = 0; i < kValue; i++) {
            if (stream[i] != value) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main dataStream = new Main(3, 5);
        System.out.println(dataStream.consec(3)); // Output: false
        System.out.println(dataStream.consec(1)); // Output: false
        System.out.println(dataStream.consec(2)); // Output: false
        System.out.println(dataStream.consec(3)); // Output: false
        System.out.println(dataStream.consec(3)); // Output: true
    }
}
