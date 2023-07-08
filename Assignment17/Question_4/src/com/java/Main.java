package com.java;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private Queue<Integer> requests;

    public Main() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);
        int startTime = t - 3000;

        while (requests.peek() < startTime) {
            requests.poll();
        }

        return requests.size();
    }

    public static void main(String[] args) {
        Main counter = new Main();
        System.out.println(counter.ping(100)); // Returns 1
        System.out.println(counter.ping(300)); // Returns 2
        System.out.println(counter.ping(600)); // Returns 3
        System.out.println(counter.ping(2000)); // Returns 4
        System.out.println(counter.ping(4000)); // Returns 1
    }
}
