package com.java;

import java.util.*;

public class Main {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        int[] revealed = new int[n];
        for (int i = 0; i < n; i++) {
            revealed[result.get(i)] = deck[i];
        }
        return revealed;
    }

    public static void main(String[] args) {
        Main cardRevealOrder = new Main();
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] revealed = cardRevealOrder.deckRevealedIncreasing(deck);
        System.out.println("Ordering to reveal cards in increasing order:");
        for (int card : revealed) {
            System.out.print(card + " ");
        }
    }
}
