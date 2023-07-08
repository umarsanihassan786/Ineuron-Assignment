package com.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private Deque<Integer> frontDeque;
    private Deque<Integer> backDeque;

    public Main() {
        frontDeque = new ArrayDeque<>();
        backDeque = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        frontDeque.push(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() > backDeque.size()) {
            backDeque.push(frontDeque.pop());
        }
        frontDeque.push(val);
    }

    public void pushBack(int val) {
        backDeque.offer(val);
        balance();
    }

    public int popFront() {
        if (isEmpty()) {
            return 1;
        }
        if (frontDeque.isEmpty()) {
            int val = backDeque.pollFirst();
            balance();
            return val;
        } else {
            return frontDeque.pop();
        }
    }

    public int popMiddle() {
        if (isEmpty()) {
            return 1;
        }
        if (frontDeque.size() == backDeque.size()) {
            return frontDeque.pop();
        } else {
            int val = frontDeque.pop();
            backDeque.push(frontDeque.pollLast());
            return val;
        }
    }

    public int popBack() {
        if (isEmpty()) {
            return 1;
        }
        if (backDeque.isEmpty()) {
            int val = frontDeque.pollLast();
            balance();
            return val;
        } else {
            return backDeque.pollLast();
        }
    }

    private void balance() {
        if (frontDeque.size() > backDeque.size() + 1) {
            backDeque.push(frontDeque.pollLast());
        } else if (frontDeque.size() < backDeque.size()) {
            frontDeque.push(backDeque.pollFirst());
        }
    }

    private boolean isEmpty() {
        return frontDeque.isEmpty() && backDeque.isEmpty();
    }

    public static void main(String[] args) {
        Main queue = new Main();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        System.out.println(queue.popFront()); // Output: 1
        System.out.println(queue.popMiddle()); // Output: 3
        System.out.println(queue.popBack()); // Output: 2
    }
}
