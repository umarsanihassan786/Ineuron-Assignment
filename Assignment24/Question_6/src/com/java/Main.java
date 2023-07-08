package com.java;

import java.util.*;

public class Main {
    public static List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Create a priority queue with custom comparator to sort words by frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String word1, String word2) {
                int freq1 = frequencyMap.get(word1);
                int freq2 = frequencyMap.get(word2);
                if (freq1 != freq2) {
                    return freq2 - freq1; // Sort by frequency in descending order
                } else {
                    return word1.compareTo(word2); // Sort by lexicographical order
                }
            }
        });

        // Add words to the priority queue
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build the result list
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Reverse the result list to get words in descending order of frequency
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> topKWords = topKFrequent(words, k);

        // Print the top k frequent words
        System.out.println("Top " + k + " frequent words:");
        for (String word : topKWords) {
            System.out.println(word);
        }
    }
}
