package com.java;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int countStudentsUnableToEat(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int unableToEat = 0;

        for (int sandwich : sandwiches) {
            if (queue.isEmpty()) {
                break;
            }

            if (queue.peek() == sandwich) {
                queue.poll();
                unableToEat = 0;
            } else {
                queue.offer(queue.poll());
                unableToEat++;
            }
        }

        return unableToEat;
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int unableToEat = countStudentsUnableToEat(students, sandwiches);
        System.out.println("Number of students unable to eat: " + unableToEat);
    }
}
